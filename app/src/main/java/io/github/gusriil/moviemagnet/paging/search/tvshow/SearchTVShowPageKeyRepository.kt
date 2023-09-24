package io.github.gusriil.moviemagnet.paging.search.tvshow

import android.content.Context
import io.github.gusriil.moviemagnet.domain.model.TVShow
import io.github.gusriil.moviemagnet.data.network.TVShowApi
import io.github.gusriil.moviemagnet.paging.BaseDataSourceFactory
import io.github.gusriil.moviemagnet.paging.BasePageKeyRepository
import java.util.concurrent.Executor

class SearchTVShowPageKeyRepository(
    api: TVShowApi,
    query: String,
    retryExecutor: Executor,
    context: Context
) : BasePageKeyRepository<TVShow>(retryExecutor) {

    override val sourceFactory: BaseDataSourceFactory<TVShow> =
        SearchTVShowDataSourceFactory(
            api = api,
            query = query,
            retryExecutor = retryExecutor,
            context = context
        )
}