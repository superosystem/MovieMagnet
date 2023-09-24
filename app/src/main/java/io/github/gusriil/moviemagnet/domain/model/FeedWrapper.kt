package io.github.gusriil.moviemagnet.domain.model

import androidx.annotation.StringRes

class FeedWrapper<T : TmdbItem>(
    val feeds: List<T>,
    @StringRes val sortTypeResourceId: Int,
    val sortType: SortType
)