package io.github.gusriil.moviemagnet.ui.paging.main.movie

import io.github.gusriil.moviemagnet.R
import io.github.gusriil.moviemagnet.domain.model.Movie
import io.github.gusriil.moviemagnet.ui.feed.NavType
import io.github.gusriil.moviemagnet.ui.paging.main.MainActivity

abstract class MoviesActivity: MainActivity<Movie>() {

    protected abstract val titleId: Int

    override val screenTitle: String
        get() = getString(titleId, getString(R.string.menu_movies))

    override val navType: NavType?
        get() = NavType.MOVIES
}