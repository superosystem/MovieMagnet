package io.github.gusriil.moviemagnet.di

import io.github.gusriil.moviemagnet.ui.feed.movie.FeedMovieFragment
import io.github.gusriil.moviemagnet.ui.feed.tvshow.FeedTVShowFragment
import io.github.gusriil.moviemagnet.ui.setting.SettingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FeedModule {

    @ContributesAndroidInjector
    internal abstract fun feedMovieFragment(): FeedMovieFragment

    @ContributesAndroidInjector
    internal abstract fun feedTVShowFragment(): FeedTVShowFragment

    @ContributesAndroidInjector
    internal abstract fun settingFragment(): SettingFragment
}