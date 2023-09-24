package io.github.gusriil.moviemagnet.paging.tvshow

import android.content.Context
import io.github.gusriil.moviemagnet.data.network.TVShowApi
import io.github.gusriil.moviemagnet.data.response.asTVShowDomainModel
import io.github.gusriil.moviemagnet.domain.model.SortType
import io.github.gusriil.moviemagnet.domain.model.TVShow
import io.github.gusriil.moviemagnet.paging.BasePageKeyedDataSource
import io.reactivex.Observable
import java.util.concurrent.Executor

class TVShowsPageKeyedDataSource(
    private val api: TVShowApi,
    private val sortType: SortType,
    retryExecutor: Executor,
    context: Context
) : BasePageKeyedDataSource<TVShow>(retryExecutor, context) {

    override fun fetchItems(page: Int): Observable<List<TVShow>> = when (sortType) {
        SortType.MOST_POPULAR -> api.popularTVSeries(page).map { it.items.asTVShowDomainModel() }
        SortType.HIGHEST_RATED -> api.topRatedTVSeries(page).map { it.items.asTVShowDomainModel() }
        SortType.UPCOMING -> api.onTheAirTVSeries(page).map { it.items.asTVShowDomainModel() }
        SortType.TRENDING -> api.trendingTVSeries(page).map { it.items.asTVShowDomainModel() }
        SortType.NOW_PLAYING -> api.airingTodayTVSeries(page).map { it.items.asTVShowDomainModel() }
    }
}