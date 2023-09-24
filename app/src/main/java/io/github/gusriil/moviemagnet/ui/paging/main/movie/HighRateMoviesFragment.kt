package io.github.gusriil.moviemagnet.ui.paging.main.movie

import io.github.gusriil.moviemagnet.domain.model.SortType.HIGHEST_RATED
import javax.inject.Inject

class HighRateMoviesFragment @Inject
constructor() : MovieFragment() {

    override val sortType = HIGHEST_RATED
}