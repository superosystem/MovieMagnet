package io.github.gusriil.moviemagnet.di.tvshow

import io.github.gusriil.moviemagnet.ui.paging.main.tvshow.OnTheAirTVShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class OnTheAirTVShowModule {

    @ContributesAndroidInjector
    internal abstract fun onTheAirTVShowFragment(): OnTheAirTVShowFragment
}