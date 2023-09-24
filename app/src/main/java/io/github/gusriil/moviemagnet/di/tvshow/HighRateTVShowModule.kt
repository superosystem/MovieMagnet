package io.github.gusriil.moviemagnet.di.tvshow

import io.github.gusriil.moviemagnet.ui.paging.main.tvshow.HighRateTVShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HighRateTVShowModule {

    @ContributesAndroidInjector
    internal abstract fun highRateTVShowFragment(): HighRateTVShowFragment
}