package io.github.gusriil.moviemagnet.paging.search.movie

import android.content.Context
import io.github.gusriil.moviemagnet.data.network.MovieApi
import io.github.gusriil.moviemagnet.data.response.asMovieDomainModel
import io.github.gusriil.moviemagnet.domain.model.Movie
import io.github.gusriil.moviemagnet.paging.BasePageKeyedDataSource
import io.reactivex.Observable
import java.util.concurrent.Executor

class SearchMoviePageKeyedDataSource(
    private val api: MovieApi,
    private val query: String,
    retryExecutor: Executor,
    context: Context
) : BasePageKeyedDataSource<Movie>(retryExecutor, context) {

    override fun fetchItems(page: Int): Observable<List<Movie>> =
        api.searchItems(page, query).map { it.items.asMovieDomainModel() }
}