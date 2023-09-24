package io.github.gusriil.moviemagnet.domain.repository

import android.content.Context
import io.github.gusriil.moviemagnet.R
import io.github.gusriil.moviemagnet.domain.model.FeedWrapper
import io.github.gusriil.moviemagnet.domain.model.TmdbItem
import io.github.gusriil.moviemagnet.domain.model.SortType
import io.github.gusriil.moviemagnet.util.Resource
import io.github.gusriil.moviemagnet.util.isNetworkAvailable
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseFeedRepository<T : TmdbItem>(
    private val context: Context,
    ioDispatcher: CoroutineDispatcher
) {

    protected abstract suspend fun popularItems(): List<T>

    protected abstract suspend fun nowPlayingItems(): List<T>

    protected abstract suspend fun latestItems(): List<T>

    protected abstract suspend fun topRatedItems(): List<T>

    protected abstract suspend fun trendingItems(): List<T>

    protected abstract fun getNowPlayingResId(): Int

    protected abstract fun getLatestResId(): Int

    val result = flow {
        emit(Resource.Loading)
        if (context.isNetworkAvailable()) {
            try {
                coroutineScope {
                    val trendingDeferred: Deferred<List<T>> = async { trendingItems() }
                    val popularDeferred: Deferred<List<T>> = async { popularItems() }
                    val nowPlayingDeferred: Deferred<List<T>> = async { nowPlayingItems() }
                    val latestDeferred: Deferred<List<T>> = async { latestItems() }
                    val topRatedDeferred: Deferred<List<T>> = async { topRatedItems() }

                    emit(
                        Resource.Success(
                            listOf(
                                FeedWrapper(
                                    trendingDeferred.await(),
                                    R.string.text_trending,
                                    SortType.TRENDING
                                ),
                                FeedWrapper(
                                    popularDeferred.await(),
                                    R.string.text_popular,
                                    SortType.MOST_POPULAR
                                ),
                                FeedWrapper(
                                    nowPlayingDeferred.await(),
                                    getNowPlayingResId(),
                                    SortType.NOW_PLAYING
                                ),
                                FeedWrapper(
                                    latestDeferred.await(),
                                    getLatestResId(),
                                    SortType.UPCOMING
                                ),
                                FeedWrapper(
                                    topRatedDeferred.await(),
                                    R.string.text_highest_rate,
                                    SortType.HIGHEST_RATED
                                )
                            )
                        )
                    )
                }
            } catch (t: Throwable) {
                emit(Resource.Error(context.getString(R.string.failed_loading_msg)))
            }
        } else {
            emit(Resource.Error(context.getString(R.string.failed_network_msg)))
        }
    }.flowOn(ioDispatcher)
}