package io.github.gusriil.moviemagnet.ui.paging.main.movie

import io.github.gusriil.moviemagnet.R
import javax.inject.Inject

class NowPlayingMoviesActivity : MoviesActivity() {

    @Inject
    lateinit var nowPlayingMoviesFragment: NowPlayingMoviesFragment

    override val titleId: Int
        get() = R.string.now_playing

    override val fragment: MovieFragment
        get() = nowPlayingMoviesFragment
}