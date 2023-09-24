package io.github.gusriil.moviemagnet.paging.search.movie

import android.content.Context
import io.github.gusriil.moviemagnet.domain.model.Movie
import io.github.gusriil.moviemagnet.data.network.MovieApi
import io.github.gusriil.moviemagnet.paging.BasePageKeyedDataSource
import io.github.gusriil.moviemagnet.paging.BaseDataSourceFactory
import java.util.concurrent.Executor

class SearchMovieDataSourceFactory(
    private val api: MovieApi,
    private val query: String,
    private val retryExecutor: Executor,
    private val context: Context
) : BaseDataSourceFactory<Movie>() {

    override val dataSource: BasePageKeyedDataSource<Movie>
        get() = SearchMoviePageKeyedDataSource(
            api = api,
            query = query,
            retryExecutor = retryExecutor,
            context = context
        )
}