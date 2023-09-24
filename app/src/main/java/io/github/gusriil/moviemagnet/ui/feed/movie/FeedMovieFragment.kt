package io.github.gusriil.moviemagnet.ui.feed.movie

import androidx.lifecycle.ViewModelProvider
import io.github.gusriil.moviemagnet.domain.model.Movie
import io.github.gusriil.moviemagnet.ui.feed.FeedFragment
import io.github.gusriil.moviemagnet.ui.feed.NavType
import javax.inject.Inject

class FeedMovieFragment @Inject
constructor() // Required empty public constructor
    : FeedFragment<Movie>() {

    @Inject
    lateinit var factory: FeedMovieViewModel.Factory

    override val viewModel
        get() = ViewModelProvider(this, factory)[FeedMovieViewModel::class.java]

    override val navType: NavType
        get() = NavType.MOVIES
}