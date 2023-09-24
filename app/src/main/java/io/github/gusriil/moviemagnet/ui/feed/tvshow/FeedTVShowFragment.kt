package io.github.gusriil.moviemagnet.ui.feed.tvshow

import androidx.lifecycle.ViewModelProvider
import io.github.gusriil.moviemagnet.domain.model.TVShow
import io.github.gusriil.moviemagnet.ui.feed.FeedFragment
import io.github.gusriil.moviemagnet.ui.feed.NavType
import javax.inject.Inject

class FeedTVShowFragment @Inject
constructor() // Required empty public constructor
    : FeedFragment<TVShow>() {

    @Inject
    lateinit var factory: FeedTVShowViewModel.Factory

    override val viewModel
        get() = ViewModelProvider(this, factory)[FeedTVShowViewModel::class.java]


    override val navType: NavType
        get() = NavType.TV_SERIES
}