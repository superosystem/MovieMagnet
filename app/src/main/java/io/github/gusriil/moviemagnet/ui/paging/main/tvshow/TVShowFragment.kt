package io.github.gusriil.moviemagnet.ui.paging.main.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.gusriil.moviemagnet.domain.model.TVShow
import io.github.gusriil.moviemagnet.data.network.TVShowApi
import io.github.gusriil.moviemagnet.ui.feed.NavType
import io.github.gusriil.moviemagnet.ui.paging.main.BaseItemFragment
import javax.inject.Inject

abstract class TVShowFragment : BaseItemFragment<TVShow>() {

    @Inject
    lateinit var api: TVShowApi

    override val viewModel by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return TVShowsViewModel(api, sortType, requireNotNull(activity).application) as T
            }
        })[TVShowsViewModel::class.java]
    }

    override val navType: NavType
        get() = NavType.TV_SERIES
}