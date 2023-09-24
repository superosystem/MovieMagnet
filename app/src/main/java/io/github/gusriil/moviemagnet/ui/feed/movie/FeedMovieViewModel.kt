package io.github.gusriil.moviemagnet.ui.feed.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.gusriil.moviemagnet.domain.model.Movie
import io.github.gusriil.moviemagnet.repository.MovieFeedRepository
import io.github.gusriil.moviemagnet.ui.feed.FeedViewModel
import javax.inject.Inject

class FeedMovieViewModel(repository: MovieFeedRepository) :
    FeedViewModel<Movie>(repository) {

    class Factory @Inject constructor(
        private val repository: MovieFeedRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(FeedMovieViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return FeedMovieViewModel(repository) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

}