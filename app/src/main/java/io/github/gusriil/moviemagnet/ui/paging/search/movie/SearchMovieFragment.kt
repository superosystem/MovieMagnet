package io.github.gusriil.moviemagnet.ui.paging.search.movie

import androidx.lifecycle.ViewModelProvider
import io.github.gusriil.moviemagnet.domain.model.Movie
import io.github.gusriil.moviemagnet.ui.feed.NavType
import io.github.gusriil.moviemagnet.ui.paging.search.BaseSearchFragment
import javax.inject.Inject

class SearchMovieFragment @Inject
constructor() // Required empty public constructor
    : BaseSearchFragment<Movie>() {

    @Inject
    lateinit var factory: SearchMovieViewModel.Factory

    override val viewModel
        get() = ViewModelProvider(this, factory)[SearchMovieViewModel::class.java]

    override val navType: NavType
        get() = NavType.MOVIES
}