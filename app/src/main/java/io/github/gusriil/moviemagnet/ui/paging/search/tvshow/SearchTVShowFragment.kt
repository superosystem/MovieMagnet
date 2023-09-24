package io.github.gusriil.moviemagnet.ui.paging.search.tvshow

import androidx.lifecycle.ViewModelProvider
import io.github.gusriil.moviemagnet.domain.model.TVShow
import io.github.gusriil.moviemagnet.ui.feed.NavType
import io.github.gusriil.moviemagnet.ui.paging.search.BaseSearchFragment
import javax.inject.Inject

class SearchTVShowFragment @Inject
constructor() // Required empty public constructor
    : BaseSearchFragment<TVShow>() {

    @Inject
    lateinit var factory: SearchTVShowViewModel.Factory

    override val viewModel
        get() = ViewModelProvider(this, factory)[SearchTVShowViewModel::class.java]

    override val navType: NavType
        get() = NavType.TV_SERIES
}