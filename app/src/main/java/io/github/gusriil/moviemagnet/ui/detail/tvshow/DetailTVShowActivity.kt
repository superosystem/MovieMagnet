package io.github.gusriil.moviemagnet.ui.detail.tvshow

import io.github.gusriil.moviemagnet.ui.detail.DetailActivity
import io.github.gusriil.moviemagnet.ui.detail.DetailFragment
import javax.inject.Inject

class DetailTVShowActivity: DetailActivity()  {

    @Inject
    lateinit var detailTVShowFragment: DetailTVShowFragment

    override val fragment: DetailFragment
        get() = detailTVShowFragment
}