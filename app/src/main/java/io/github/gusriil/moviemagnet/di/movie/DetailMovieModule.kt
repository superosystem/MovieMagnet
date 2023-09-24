package io.github.gusriil.moviemagnet.di.movie

import io.github.gusriil.moviemagnet.domain.model.TmdbItem
import io.github.gusriil.moviemagnet.ui.detail.movie.DetailMovieActivity
import io.github.gusriil.moviemagnet.ui.detail.movie.DetailMovieFragment
import io.github.gusriil.moviemagnet.util.Constants.EXTRA_TMDB_ITEM
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailMovieModule {

    @ContributesAndroidInjector
    internal abstract fun detailMovieFragment(): DetailMovieFragment

    @Module
    companion object {
        @Provides
        @JvmStatic
        internal fun provideTmdbItem(activity: DetailMovieActivity): TmdbItem =
            activity.intent.extras?.getParcelable(EXTRA_TMDB_ITEM)!!
    }
}
