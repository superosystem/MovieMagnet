package io.github.gusriil.moviemagnet.ui.paging.main.tvshow

import io.github.gusriil.moviemagnet.domain.model.SortType
import javax.inject.Inject

class AiringTodayTVShowsFragment @Inject
constructor() : TVShowFragment() {

    override val sortType = SortType.NOW_PLAYING
}