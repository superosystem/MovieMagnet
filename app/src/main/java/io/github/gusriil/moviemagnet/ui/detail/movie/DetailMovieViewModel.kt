package io.github.gusriil.moviemagnet.ui.detail.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.gusriil.moviemagnet.domain.model.TmdbItem
import io.github.gusriil.moviemagnet.domain.repository.MovieDetailRepository
import io.github.gusriil.moviemagnet.ui.detail.DetailViewModel
import javax.inject.Inject

class DetailMovieViewModel(
    repository: MovieDetailRepository,
    item: TmdbItem
) : DetailViewModel(
    repository.getMovieTrailers(item.id),
    repository.getMovieCredit(item.id)
) {

    class Factory @Inject constructor(
        private val repository: MovieDetailRepository,
        private val item: TmdbItem
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetailMovieViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return DetailMovieViewModel(repository, item) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}