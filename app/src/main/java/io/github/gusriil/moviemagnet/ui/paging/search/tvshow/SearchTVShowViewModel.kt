package io.github.gusriil.moviemagnet.ui.paging.search.tvshow

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.gusriil.moviemagnet.domain.model.TVShow
import io.github.gusriil.moviemagnet.data.network.TVShowApi
import io.github.gusriil.moviemagnet.paging.BasePageKeyRepository
import io.github.gusriil.moviemagnet.paging.search.tvshow.SearchTVShowPageKeyRepository
import io.github.gusriil.moviemagnet.ui.paging.search.BaseSearchViewModel
import javax.inject.Inject

class SearchTVShowViewModel(
        private val api: TVShowApi,
        private val app: Application
) : BaseSearchViewModel<TVShow>(app = app) {

    override fun searchRepoResult(query: String): BasePageKeyRepository<TVShow> =
            SearchTVShowPageKeyRepository(api, query, networkIO, app.applicationContext)

    class Factory @Inject constructor(
            private val api: TVShowApi,
            private val app: Application
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SearchTVShowViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return SearchTVShowViewModel(api, app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}