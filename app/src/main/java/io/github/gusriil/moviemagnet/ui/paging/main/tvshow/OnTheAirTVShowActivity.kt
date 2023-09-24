package io.github.gusriil.moviemagnet.ui.paging.main.tvshow

import io.github.gusriil.moviemagnet.R
import javax.inject.Inject

class OnTheAirTVShowActivity: TVShowActivity() {

    @Inject
    lateinit var onTheAirTVShowFragment: OnTheAirTVShowFragment

    override val titleId: Int
        get() = R.string.on_the_air

    override val fragment: TVShowFragment
        get() = onTheAirTVShowFragment
}