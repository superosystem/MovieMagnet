package io.github.gusriil.moviemagnet.di.tvshow

import io.github.gusriil.moviemagnet.ui.paging.main.tvshow.PopularTVShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PopularTVShowModule {

    @ContributesAndroidInjector
    internal abstract fun popularTVShowFragment(): PopularTVShowFragment
}