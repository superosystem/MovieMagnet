package io.github.gusriil.moviemagnet.di.tvshow

import io.github.gusriil.moviemagnet.ui.paging.main.tvshow.TrendingTVShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TrendingTVShowModule {

    @ContributesAndroidInjector
    internal abstract fun trendingTVShowFragment(): TrendingTVShowFragment
}