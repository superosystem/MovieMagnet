package io.github.gusriil.moviemagnet.di.tvshow

import io.github.gusriil.moviemagnet.ui.paging.main.tvshow.AiringTodayTVShowsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AiringTodayTVShowModule {

    @ContributesAndroidInjector
    internal abstract fun airingTodayTVShowFragment(): AiringTodayTVShowsFragment
}