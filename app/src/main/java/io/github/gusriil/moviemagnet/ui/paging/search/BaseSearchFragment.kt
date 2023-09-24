package io.github.gusriil.moviemagnet.ui.paging.search

import io.github.gusriil.moviemagnet.domain.model.TmdbItem
import io.github.gusriil.moviemagnet.paging.Status.RUNNING
import io.github.gusriil.moviemagnet.ui.paging.BaseFragment
import io.github.gusriil.moviemagnet.util.toVisibility

abstract class BaseSearchFragment<T : TmdbItem> : BaseFragment<T>() {

    private val searchViewModel
        get() = viewModel as BaseSearchViewModel

    override fun refresh() {
        super.refresh()
        searchViewModel.refreshState.removeObservers(this)
    }

    fun search(query: String) {
        if (searchViewModel.showQuery(query)) {
            binding.recyclerView.scrollToPosition(0)
            tmdbAdapter.submitList(null)
        }
    }

    fun observeRefreshState() {
        searchViewModel.refreshState.observe(this) {
            binding.recyclerView.toVisibility(it.status != RUNNING)
        }
    }
}