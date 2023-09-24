package io.github.gusriil.moviemagnet.ui.paging.main.movie

import io.github.gusriil.moviemagnet.R
import javax.inject.Inject

class PopularMoviesActivity: MoviesActivity() {

    @Inject
    lateinit var popularMoviesFragment: PopularMoviesFragment

    override val titleId: Int
        get() = R.string.popular

    override val fragment: MovieFragment
        get() = popularMoviesFragment
}