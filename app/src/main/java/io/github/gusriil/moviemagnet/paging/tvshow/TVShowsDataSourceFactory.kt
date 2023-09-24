package io.github.gusriil.moviemagnet.paging.tvshow

import android.content.Context
import io.github.gusriil.moviemagnet.domain.model.TVShow
import io.github.gusriil.moviemagnet.data.network.TVShowApi
import io.github.gusriil.moviemagnet.paging.BaseDataSourceFactory
import io.github.gusriil.moviemagnet.paging.BasePageKeyedDataSource
import io.github.gusriil.moviemagnet.domain.model.SortType
import java.util.concurrent.Executor

class TVShowsDataSourceFactory(
    private val api: TVShowApi,
    private val sortType: SortType,
    private val retryExecutor: Executor,
    private val context: Context
) : BaseDataSourceFactory<TVShow>() {

    override val dataSource: BasePageKeyedDataSource<TVShow>
        get() = TVShowsPageKeyedDataSource(
            api = api,
            sortType = sortType,
            retryExecutor = retryExecutor,
            context = context
        )
}