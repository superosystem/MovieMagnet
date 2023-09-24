package io.github.gusriil.moviemagnet.di.movie

import io.github.gusriil.moviemagnet.ui.paging.main.movie.PopularMoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PopularMoviesModule {

    @ContributesAndroidInjector
    internal abstract fun popularMoviesFragment(): PopularMoviesFragment
}