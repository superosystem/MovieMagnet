package io.github.gusriil.moviemagnet.ui.paging.main.movie

import io.github.gusriil.moviemagnet.domain.model.SortType.MOST_POPULAR
import javax.inject.Inject

class PopularMoviesFragment @Inject
constructor() : MovieFragment() {

    override val sortType = MOST_POPULAR
}