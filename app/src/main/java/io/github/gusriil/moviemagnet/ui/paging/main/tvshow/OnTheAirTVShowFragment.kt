package io.github.gusriil.moviemagnet.ui.paging.main.tvshow

import io.github.gusriil.moviemagnet.domain.model.SortType.UPCOMING
import javax.inject.Inject

class OnTheAirTVShowFragment @Inject
constructor() : TVShowFragment() {

    override val sortType = UPCOMING
}