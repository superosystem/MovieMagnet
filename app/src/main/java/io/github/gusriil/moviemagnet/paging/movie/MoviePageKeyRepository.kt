package io.github.gusriil.moviemagnet.paging.movie

import android.content.Context
import io.github.gusriil.moviemagnet.domain.model.Movie
import io.github.gusriil.moviemagnet.data.network.MovieApi
import io.github.gusriil.moviemagnet.paging.BaseDataSourceFactory
import io.github.gusriil.moviemagnet.paging.BasePageKeyRepository
import io.github.gusriil.moviemagnet.domain.model.SortType
import java.util.concurrent.Executor

class MoviePageKeyRepository(
    api: MovieApi,
    sortType: SortType,
    retryExecutor: Executor,
    context: Context
) : BasePageKeyRepository<Movie>(retryExecutor) {

    override val sourceFactory: BaseDataSourceFactory<Movie> =
        MoviesDataSourceFactory(
            api = api,
            sortType = sortType,
            retryExecutor = retryExecutor,
            context = context
        )
}