package io.github.gusriil.moviemagnet.ui.paging.main.movie

import io.github.gusriil.moviemagnet.R
import javax.inject.Inject

class UpcomingMoviesActivity: MoviesActivity() {

    @Inject
    lateinit var upcomingMoviesFragment: UpcomingMoviesFragment

    override val titleId: Int
        get() = R.string.upcoming

    override val fragment: MovieFragment
        get() = upcomingMoviesFragment
}