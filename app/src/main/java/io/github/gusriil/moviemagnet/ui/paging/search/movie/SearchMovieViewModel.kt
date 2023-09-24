package io.github.gusriil.moviemagnet.ui.paging.search.movie

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.gusriil.moviemagnet.domain.model.Movie
import io.github.gusriil.moviemagnet.data.network.MovieApi
import io.github.gusriil.moviemagnet.paging.BasePageKeyRepository
import io.github.gusriil.moviemagnet.paging.search.movie.SearchMoviePageKeyRepository
import io.github.gusriil.moviemagnet.ui.paging.search.BaseSearchViewModel
import javax.inject.Inject

class SearchMovieViewModel(
        private val api: MovieApi,
        private val app: Application
) : BaseSearchViewModel<Movie>(app = app) {

    override fun searchRepoResult(query: String): BasePageKeyRepository<Movie> =
            SearchMoviePageKeyRepository(api, query, networkIO, app.applicationContext)

    class Factory @Inject constructor(
            private val api: MovieApi,
            private val app: Application
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SearchMovieViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return SearchMovieViewModel(api, app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}