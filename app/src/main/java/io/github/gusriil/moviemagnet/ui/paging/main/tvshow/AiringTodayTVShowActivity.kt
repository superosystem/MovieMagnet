package io.github.gusriil.moviemagnet.ui.paging.main.tvshow

import io.github.gusriil.moviemagnet.R
import javax.inject.Inject

class AiringTodayTVShowActivity: TVShowActivity() {

    @Inject
    lateinit var airingTodayTVShowFragment: AiringTodayTVShowsFragment

    override val titleId: Int
        get() = R.string.airing_today

    override val fragment: TVShowFragment
        get() = airingTodayTVShowFragment
}