package io.github.gusriil.moviemagnet.ui.paging.main.movie

import io.github.gusriil.moviemagnet.domain.model.SortType
import javax.inject.Inject

class TrendingMoviesFragment @Inject
constructor() : MovieFragment() {

    override val sortType = SortType.TRENDING
}