package io.github.gusriil.moviemagnet.ui

import android.app.ActivityOptions
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import io.github.gusriil.moviemagnet.R
import io.github.gusriil.moviemagnet.ui.feed.NavType
import io.github.gusriil.moviemagnet.ui.paging.search.movie.SearchMovieActivity
import io.github.gusriil.moviemagnet.ui.paging.search.tvshow.SearchTVShowActivity

abstract class BaseNavTypeActivity : BaseActivity() {

    protected abstract val toolbar: Toolbar

    protected abstract val navType: NavType?

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        if (navType == NavType.SETTING) {
            menu.getItem(0).isVisible = false
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_search -> {
                val searchMenuView: View = toolbar.findViewById(R.id.action_search)
                val options = ActivityOptions.makeSceneTransitionAnimation(
                    this,
                    searchMenuView, getString(R.string.transition_search_back)
                )

                val activity = when (navType) {
                    NavType.MOVIES -> SearchMovieActivity::class.java
                    NavType.TV_SERIES -> SearchTVShowActivity::class.java
                    else -> throw RuntimeException("Unknown search navigation type")
                }
                val intent = Intent(this, activity)
                // Bundle introduce an unexpected result in destination Activity.
                // See https://issuetracker.google.com/issues/251812970
                startActivity(intent, options.toBundle())
            }
        }
        return super.onOptionsItemSelected(item)
    }
}