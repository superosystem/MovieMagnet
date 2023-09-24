package io.github.gusriil.moviemagnet.ui.paging.main.tvshow

import io.github.gusriil.moviemagnet.R
import javax.inject.Inject

class HighRateTVShowActivity: TVShowActivity() {

    @Inject
    lateinit var highRateTVShowFragment: HighRateTVShowFragment

    override val titleId: Int
        get() = R.string.highest_rate

    override val fragment: TVShowFragment
        get() = highRateTVShowFragment
}