package io.github.gusriil.moviemagnet.repository

import android.content.Context
import io.github.gusriil.moviemagnet.R
import io.github.gusriil.moviemagnet.data.response.asMovieDomainModel
import io.github.gusriil.moviemagnet.di.IoDispatcher
import io.github.gusriil.moviemagnet.domain.repository.BaseFeedRepository
import io.github.gusriil.moviemagnet.domain.model.Movie
import io.github.gusriil.moviemagnet.data.network.MovieApi
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieFeedRepository @Inject constructor(
    context: Context,
    @IoDispatcher ioDispatcher: CoroutineDispatcher,
    private val movieApi: MovieApi,
): BaseFeedRepository<Movie>(context, ioDispatcher) {

    override suspend fun popularItems(): List<Movie> = movieApi.popularMovies().items.asMovieDomainModel()

    override suspend fun latestItems(): List<Movie> = movieApi.upcomingMovies().items.asMovieDomainModel()

    override suspend fun topRatedItems(): List<Movie> = movieApi.topRatedMovies().items.asMovieDomainModel()

    override suspend fun trendingItems(): List<Movie> = movieApi.trendingMovies().items.asMovieDomainModel()

    override suspend fun nowPlayingItems(): List<Movie> = movieApi.nowPlayingMovies().items.asMovieDomainModel()

    override fun getNowPlayingResId(): Int = R.string.text_now_playing

    override fun getLatestResId(): Int = R.string.text_upcoming
}