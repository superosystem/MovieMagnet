package io.github.gusriil.moviemagnet.ui.paging.main.movie

import io.github.gusriil.moviemagnet.R
import javax.inject.Inject

class TrendingMoviesActivity: MoviesActivity() {

    @Inject
    lateinit var trendingMoviesFragment: TrendingMoviesFragment

    override val titleId: Int
        get() = R.string.trending

    override val fragment: MovieFragment
        get() = trendingMoviesFragment
}