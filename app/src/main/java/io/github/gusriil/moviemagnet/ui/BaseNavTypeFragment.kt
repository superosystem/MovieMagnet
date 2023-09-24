package io.github.gusriil.moviemagnet.ui

import android.content.Intent
import android.os.Bundle
import io.github.gusriil.moviemagnet.domain.model.TmdbItem
import io.github.gusriil.moviemagnet.ui.detail.movie.DetailMovieActivity
import io.github.gusriil.moviemagnet.ui.detail.tvshow.DetailTVShowActivity
import io.github.gusriil.moviemagnet.ui.feed.NavType
import io.github.gusriil.moviemagnet.util.Constants
import dagger.android.support.DaggerFragment

abstract class BaseNavTypeFragment : DaggerFragment()  {

    protected abstract val navType: NavType

    protected fun startDetailActivity(tmdbItem: TmdbItem) {
        val activity = when (navType) {
            NavType.MOVIES -> DetailMovieActivity::class.java
            NavType.TV_SERIES -> DetailTVShowActivity::class.java
            else -> throw RuntimeException("Unknown item to start detail Activity")
        }
        val intent = Intent(requireActivity(), activity).apply {
            putExtras(Bundle().apply {
                putParcelable(Constants.EXTRA_TMDB_ITEM, tmdbItem)
            })
        }
        startActivity(intent)
    }
}