package io.github.gusriil.moviemagnet.di.movie

import io.github.gusriil.moviemagnet.ui.paging.main.movie.UpcomingMoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UpcomingMoviesModule {

    @ContributesAndroidInjector
    internal abstract fun upcomingMoviesFragment(): UpcomingMoviesFragment
}