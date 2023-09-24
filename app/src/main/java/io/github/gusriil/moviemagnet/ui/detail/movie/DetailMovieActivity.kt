package io.github.gusriil.moviemagnet.ui.detail.movie

import io.github.gusriil.moviemagnet.ui.detail.DetailActivity
import io.github.gusriil.moviemagnet.ui.detail.DetailFragment
import javax.inject.Inject

class DetailMovieActivity: DetailActivity() {

    @Inject
    lateinit var detailMovieFragment: DetailMovieFragment

    override val fragment: DetailFragment
        get() = detailMovieFragment
}