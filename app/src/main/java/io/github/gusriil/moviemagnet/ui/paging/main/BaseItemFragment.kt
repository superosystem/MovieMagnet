package io.github.gusriil.moviemagnet.ui.paging.main

import io.github.gusriil.moviemagnet.domain.model.SortType
import io.github.gusriil.moviemagnet.domain.model.TmdbItem
import io.github.gusriil.moviemagnet.ui.paging.BaseFragment

abstract class BaseItemFragment<T : TmdbItem> : BaseFragment<T>() {

    protected abstract val sortType: SortType
}