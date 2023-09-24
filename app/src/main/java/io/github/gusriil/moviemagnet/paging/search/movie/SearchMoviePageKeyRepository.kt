package io.github.gusriil.moviemagnet.paging.search.movie

import android.content.Context
import io.github.gusriil.moviemagnet.domain.model.Movie
import io.github.gusriil.moviemagnet.data.network.MovieApi
import io.github.gusriil.moviemagnet.paging.BaseDataSourceFactory
import io.github.gusriil.moviemagnet.paging.BasePageKeyRepository
import java.util.concurrent.Executor

class SearchMoviePageKeyRepository(
    api: MovieApi,
    query: String,
    retryExecutor: Executor,
    context: Context
) : BasePageKeyRepository<Movie>(retryExecutor) {

    override val sourceFactory: BaseDataSourceFactory<Movie> =
        SearchMovieDataSourceFactory(
            api = api,
            query = query,
            retryExecutor = retryExecutor,
            context = context
        )
}