package io.github.gusriil.moviemagnet.ui.paging.search.movie

import io.github.gusriil.moviemagnet.R
import io.github.gusriil.moviemagnet.domain.model.Movie
import io.github.gusriil.moviemagnet.ui.paging.search.SearchActivity
import javax.inject.Inject

class SearchMovieActivity: SearchActivity<Movie>() {

    @Inject
    lateinit var searchMovieFragment: SearchMovieFragment

    override val fragment: SearchMovieFragment
        get() = searchMovieFragment

    override val hintId: Int
        get() = R.string.search_hint_movies
}