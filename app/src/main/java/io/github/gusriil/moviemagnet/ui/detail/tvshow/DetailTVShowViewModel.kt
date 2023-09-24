package io.github.gusriil.moviemagnet.ui.detail.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.gusriil.moviemagnet.domain.model.TmdbItem
import io.github.gusriil.moviemagnet.domain.repository.TVShowDetailRepository
import io.github.gusriil.moviemagnet.ui.detail.DetailViewModel
import javax.inject.Inject

class DetailTVShowViewModel(
    repository: TVShowDetailRepository,
    item: TmdbItem
) : DetailViewModel(
    repository.getTVShowTrailers(item.id),
    repository.getTVShowCredit(item.id)
) {

    class Factory @Inject constructor(
        private val repository: TVShowDetailRepository,
        private val item: TmdbItem
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetailTVShowViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return DetailTVShowViewModel(repository, item) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}