package io.github.gusriil.moviemagnet.ui.paging.main.movie

import io.github.gusriil.moviemagnet.R
import javax.inject.Inject

class HighRateMoviesActivity: MoviesActivity() {

    @Inject
    lateinit var highRateMoviesFragment: HighRateMoviesFragment

    override val titleId: Int
        get() = R.string.highest_rate

    override val fragment: MovieFragment
        get() = highRateMoviesFragment
}