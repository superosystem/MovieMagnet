package io.github.gusriil.moviemagnet.di.movie

import io.github.gusriil.moviemagnet.ui.paging.main.movie.HighRateMoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HighRateMoviesModule {

    @ContributesAndroidInjector
    internal abstract fun highRateMoviesFragment(): HighRateMoviesFragment
}