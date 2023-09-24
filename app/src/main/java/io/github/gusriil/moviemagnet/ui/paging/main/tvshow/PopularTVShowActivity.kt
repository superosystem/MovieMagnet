package io.github.gusriil.moviemagnet.ui.paging.main.tvshow

import io.github.gusriil.moviemagnet.R
import javax.inject.Inject

class PopularTVShowActivity: TVShowActivity() {

    @Inject
    lateinit var popularTVShowFragment: PopularTVShowFragment

    override val titleId: Int
        get() = R.string.popular

    override val fragment: TVShowFragment
        get() = popularTVShowFragment
}