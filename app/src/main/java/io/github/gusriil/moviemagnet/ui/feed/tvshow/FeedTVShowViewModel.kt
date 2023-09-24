package io.github.gusriil.moviemagnet.ui.feed.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.gusriil.moviemagnet.domain.model.TVShow
import io.github.gusriil.moviemagnet.repository.TVShowFeedRepository
import io.github.gusriil.moviemagnet.ui.feed.FeedViewModel
import javax.inject.Inject

class FeedTVShowViewModel(repository: TVShowFeedRepository) :
    FeedViewModel<TVShow>(repository) {

    class Factory @Inject constructor(
        private val repository: TVShowFeedRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(FeedTVShowViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return FeedTVShowViewModel(repository) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}