package io.github.gusriil.moviemagnet.ui.paging.main.tvshow

import android.app.Application
import io.github.gusriil.moviemagnet.domain.model.TVShow
import io.github.gusriil.moviemagnet.data.network.TVShowApi
import io.github.gusriil.moviemagnet.paging.BasePageKeyRepository
import io.github.gusriil.moviemagnet.paging.tvshow.TVShowsPageKeyRepository
import io.github.gusriil.moviemagnet.ui.paging.main.BaseItemViewModel
import io.github.gusriil.moviemagnet.domain.model.SortType

class TVShowsViewModel(
        api: TVShowApi,
        sortType: SortType,
        app: Application
) : BaseItemViewModel<TVShow>(app = app) {

    override val mainRepoResult: BasePageKeyRepository<TVShow> = TVShowsPageKeyRepository(api = api,
            sortType = sortType,
            retryExecutor = networkIO,
            context = app.applicationContext)
}