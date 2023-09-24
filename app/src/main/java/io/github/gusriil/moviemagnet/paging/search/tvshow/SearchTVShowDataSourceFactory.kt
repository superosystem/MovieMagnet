package io.github.gusriil.moviemagnet.paging.search.tvshow

import android.content.Context
import io.github.gusriil.moviemagnet.domain.model.TVShow
import io.github.gusriil.moviemagnet.data.network.TVShowApi
import io.github.gusriil.moviemagnet.paging.BaseDataSourceFactory
import io.github.gusriil.moviemagnet.paging.BasePageKeyedDataSource
import java.util.concurrent.Executor

class SearchTVShowDataSourceFactory(
    private val api: TVShowApi,
    private val query: String,
    private val retryExecutor: Executor,
    private val context: Context
) : BaseDataSourceFactory<TVShow>() {

    override val dataSource: BasePageKeyedDataSource<TVShow>
        get() = SearchTVShowPageKeyedDataSource(
            api = api,
            query = query,
            retryExecutor = retryExecutor,
            context = context
        )
}