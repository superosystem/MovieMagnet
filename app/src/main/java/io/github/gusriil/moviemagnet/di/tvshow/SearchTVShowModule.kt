package io.github.gusriil.moviemagnet.di.tvshow

import io.github.gusriil.moviemagnet.ui.paging.search.tvshow.SearchTVShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SearchTVShowModule {

    @ContributesAndroidInjector
    internal abstract fun searchTVShowFragment(): SearchTVShowFragment
}