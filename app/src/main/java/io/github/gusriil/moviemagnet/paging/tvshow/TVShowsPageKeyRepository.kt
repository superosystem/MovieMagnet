package io.github.gusriil.moviemagnet.paging.tvshow

import android.content.Context
import io.github.gusriil.moviemagnet.domain.model.TVShow
import io.github.gusriil.moviemagnet.data.network.TVShowApi
import io.github.gusriil.moviemagnet.paging.BaseDataSourceFactory
import io.github.gusriil.moviemagnet.paging.BasePageKeyRepository
import io.github.gusriil.moviemagnet.domain.model.SortType
import java.util.concurrent.Executor

class TVShowsPageKeyRepository(
    api: TVShowApi,
    sortType: SortType,
    retryExecutor: Executor,
    context: Context
) : BasePageKeyRepository<TVShow>(retryExecutor) {

    override val sourceFactory: BaseDataSourceFactory<TVShow> =
        TVShowsDataSourceFactory(
            api = api,
            sortType = sortType,
            retryExecutor = retryExecutor,
            context = context
        )
}