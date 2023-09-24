package io.github.gusriil.moviemagnet.ui.paging.main.tvshow

import io.github.gusriil.moviemagnet.domain.model.SortType.HIGHEST_RATED
import javax.inject.Inject

class HighRateTVShowFragment @Inject
constructor() : TVShowFragment() {

    override val sortType = HIGHEST_RATED
}