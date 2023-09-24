package io.github.gusriil.moviemagnet.di.movie

import io.github.gusriil.moviemagnet.ui.paging.search.movie.SearchMovieFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchMovieModule {

    @ContributesAndroidInjector
    internal abstract fun searchMovieFragment(): SearchMovieFragment
}