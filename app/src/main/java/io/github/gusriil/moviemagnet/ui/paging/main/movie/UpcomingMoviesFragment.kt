package io.github.gusriil.moviemagnet.ui.paging.main.movie

import io.github.gusriil.moviemagnet.domain.model.SortType.UPCOMING
import javax.inject.Inject

class UpcomingMoviesFragment @Inject
constructor() : MovieFragment() {

    override val sortType = UPCOMING
}