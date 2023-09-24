package io.github.gusriil.moviemagnet.paging.movie

import android.content.Context
import io.github.gusriil.moviemagnet.data.network.MovieApi
import io.github.gusriil.moviemagnet.data.response.asMovieDomainModel
import io.github.gusriil.moviemagnet.domain.model.Movie
import io.github.gusriil.moviemagnet.domain.model.SortType
import io.github.gusriil.moviemagnet.paging.BasePageKeyedDataSource
import io.reactivex.Observable
import java.util.concurrent.Executor

class MoviePageKeyedDataSource(
    private val api: MovieApi,
    private val sortType: SortType,
    retryExecutor: Executor,
    context: Context
) : BasePageKeyedDataSource<Movie>(retryExecutor, context) {

    override fun fetchItems(page: Int): Observable<List<Movie>> = when (sortType) {
        SortType.MOST_POPULAR -> api.popularMovies(page).map { it.items.asMovieDomainModel() }
        SortType.HIGHEST_RATED -> api.topRatedMovies(page).map { it.items.asMovieDomainModel() }
        SortType.UPCOMING -> api.upcomingMovies(page).map { it.items.asMovieDomainModel() }
        SortType.TRENDING -> api.trendingMovies(page).map { it.items.asMovieDomainModel() }
        SortType.NOW_PLAYING -> api.nowPlayingMovies(page).map { it.items.asMovieDomainModel() }
    }
}