package io.github.gusriil.moviemagnet.paging.movie

import android.content.Context
import io.github.gusriil.moviemagnet.domain.model.Movie
import io.github.gusriil.moviemagnet.data.network.MovieApi
import io.github.gusriil.moviemagnet.paging.BaseDataSourceFactory
import io.github.gusriil.moviemagnet.paging.BasePageKeyedDataSource
import io.github.gusriil.moviemagnet.domain.model.SortType
import java.util.concurrent.Executor

class MoviesDataSourceFactory(
    private val api: MovieApi,
    private val sortType: SortType,
    private val retryExecutor: Executor,
    private val context: Context
) : BaseDataSourceFactory<Movie>() {

    override val dataSource: BasePageKeyedDataSource<Movie>
        get() = MoviePageKeyedDataSource(
            api = api,
            sortType = sortType,
            retryExecutor = retryExecutor,
            context = context
        )
}
