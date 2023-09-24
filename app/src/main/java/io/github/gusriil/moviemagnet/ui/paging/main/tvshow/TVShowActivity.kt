package io.github.gusriil.moviemagnet.ui.paging.main.tvshow

import io.github.gusriil.moviemagnet.R
import io.github.gusriil.moviemagnet.domain.model.TVShow
import io.github.gusriil.moviemagnet.ui.feed.NavType
import io.github.gusriil.moviemagnet.ui.paging.main.MainActivity

abstract class TVShowActivity: MainActivity<TVShow>() {

    protected abstract val titleId: Int

    override val screenTitle: String
        get() = getString(titleId, getString(R.string.menu_tv_series))

    override val navType: NavType?
        get() = NavType.TV_SERIES
}