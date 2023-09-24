package io.github.gusriil.moviemagnet.repository

import android.content.Context
import io.github.gusriil.moviemagnet.R
import io.github.gusriil.moviemagnet.data.response.asTVShowDomainModel
import io.github.gusriil.moviemagnet.di.IoDispatcher
import io.github.gusriil.moviemagnet.domain.repository.BaseFeedRepository
import io.github.gusriil.moviemagnet.domain.model.TVShow
import io.github.gusriil.moviemagnet.data.network.TVShowApi
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TVShowFeedRepository @Inject constructor(
    context: Context,
    @IoDispatcher ioDispatcher: CoroutineDispatcher,
    private val tvShowApi: TVShowApi,
) : BaseFeedRepository<TVShow>(context, ioDispatcher) {

    override suspend fun popularItems(): List<TVShow> = tvShowApi.popularTVSeries().items.asTVShowDomainModel()

    override suspend fun latestItems(): List<TVShow> = tvShowApi.onTheAirTVSeries().items.asTVShowDomainModel()

    override suspend fun topRatedItems(): List<TVShow> = tvShowApi.topRatedTVSeries().items.asTVShowDomainModel()

    override suspend fun trendingItems(): List<TVShow> = tvShowApi.trendingTVSeries().items.asTVShowDomainModel()

    override suspend fun nowPlayingItems(): List<TVShow> = tvShowApi.airingTodayTVSeries().items.asTVShowDomainModel()

    override fun getNowPlayingResId(): Int = R.string.text_airing_today

    override fun getLatestResId(): Int = R.string.text_on_the_air
}