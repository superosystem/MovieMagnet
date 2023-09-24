package io.github.gusriil.moviemagnet.ui.paging.main.tvshow

import io.github.gusriil.moviemagnet.domain.model.SortType.MOST_POPULAR
import javax.inject.Inject

class PopularTVShowFragment @Inject
constructor() : TVShowFragment() {

    override val sortType = MOST_POPULAR
}