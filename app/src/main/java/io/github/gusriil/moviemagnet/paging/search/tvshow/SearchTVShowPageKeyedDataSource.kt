package io.github.gusriil.moviemagnet.paging.search.tvshow

import android.content.Context
import io.github.gusriil.moviemagnet.data.network.TVShowApi
import io.github.gusriil.moviemagnet.data.response.asTVShowDomainModel
import io.github.gusriil.moviemagnet.domain.model.TVShow
import io.github.gusriil.moviemagnet.paging.BasePageKeyedDataSource
import io.reactivex.Observable
import java.util.concurrent.Executor

class SearchTVShowPageKeyedDataSource(
    private val api: TVShowApi,
    private val query: String,
    retryExecutor: Executor,
    context: Context
) : BasePageKeyedDataSource<TVShow>(retryExecutor, context) {

    override fun fetchItems(page: Int): Observable<List<TVShow>> =
        api.searchItems(page, query).map { it.items.asTVShowDomainModel() }
}