package io.github.gusriil.moviemagnet.di.tvshow

import io.github.gusriil.moviemagnet.domain.model.TmdbItem
import io.github.gusriil.moviemagnet.ui.detail.tvshow.DetailTVShowActivity
import io.github.gusriil.moviemagnet.ui.detail.tvshow.DetailTVShowFragment
import io.github.gusriil.moviemagnet.util.Constants.EXTRA_TMDB_ITEM
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailTVShowModule {

    @ContributesAndroidInjector
    internal abstract fun tvShowDetailFragment(): DetailTVShowFragment

    @Module
    companion object {
        @Provides
        @JvmStatic
        internal fun provideTmdbItem(activity: DetailTVShowActivity): TmdbItem =
            activity.intent.extras?.getParcelable(EXTRA_TMDB_ITEM)!!
    }
}