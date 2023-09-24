package io.github.gusriil.moviemagnet.di.movie

import io.github.gusriil.moviemagnet.ui.paging.main.movie.NowPlayingMoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NowPlayingMoviesModule {

    @ContributesAndroidInjector
    internal abstract fun nowPlayingMoviesFragment(): NowPlayingMoviesFragment
}