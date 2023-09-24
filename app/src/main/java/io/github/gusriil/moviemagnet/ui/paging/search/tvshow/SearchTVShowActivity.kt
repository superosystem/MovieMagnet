package io.github.gusriil.moviemagnet.ui.paging.search.tvshow

import io.github.gusriil.moviemagnet.R
import io.github.gusriil.moviemagnet.domain.model.TVShow
import io.github.gusriil.moviemagnet.ui.paging.search.SearchActivity
import javax.inject.Inject

class SearchTVShowActivity: SearchActivity<TVShow>() {

    @Inject
    lateinit var searchTVShowFragment: SearchTVShowFragment

    override val fragment: SearchTVShowFragment
        get() = searchTVShowFragment

    override val hintId: Int
        get() = R.string.search_hint_tv_shows
}