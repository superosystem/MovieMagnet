package io.github.gusriil.moviemagnet.di.movie

import io.github.gusriil.moviemagnet.ui.paging.main.movie.TrendingMoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TrendingMoviesModule {

    @ContributesAndroidInjector
    internal abstract fun trendingMoviesFragment(): TrendingMoviesFragment
}