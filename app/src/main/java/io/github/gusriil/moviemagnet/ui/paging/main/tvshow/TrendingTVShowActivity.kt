package io.github.gusriil.moviemagnet.ui.paging.main.tvshow

import io.github.gusriil.moviemagnet.R
import javax.inject.Inject

class TrendingTVShowActivity: TVShowActivity() {

    @Inject
    lateinit var trendingTVShowFragment: TrendingTVShowFragment

    override val titleId: Int
        get() = R.string.trending

    override val fragment: TVShowFragment
        get() = trendingTVShowFragment
}