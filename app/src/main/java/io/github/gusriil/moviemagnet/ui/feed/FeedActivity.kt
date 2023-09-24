package io.github.gusriil.moviemagnet.ui.feed

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import io.github.gusriil.moviemagnet.R
import io.github.gusriil.moviemagnet.databinding.ActivityFeedBinding
import io.github.gusriil.moviemagnet.ui.BaseNavTypeActivity
import io.github.gusriil.moviemagnet.ui.feed.movie.FeedMovieFragment
import io.github.gusriil.moviemagnet.ui.feed.tvshow.FeedTVShowFragment
import io.github.gusriil.moviemagnet.ui.setting.SettingFragment
import io.github.gusriil.moviemagnet.util.addFragmentToActivity
import io.github.gusriil.moviemagnet.util.replaceFragmentInActivity
import javax.inject.Inject

class FeedActivity : BaseNavTypeActivity() {

    @Inject
    lateinit var feedMovieFragment: FeedMovieFragment

    @Inject
    lateinit var feedTVShowFragment: FeedTVShowFragment

    @Inject
    lateinit var settingFragment: SettingFragment

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityFeedBinding

    override val navType: NavType?
        get() = viewModel.currentType.value

    override val toolbar: Toolbar
        get() = binding.toolbar

    override val networkStatusLayout: View
        get() = binding.networkStatusLayout

    override val textViewNetworkStatus: TextView
        get() = binding.textViewNetworkStatus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        viewModel.headline.observe(this) {
            title = getString(it)
        }
        if (savedInstanceState == null) {
            addFragmentToActivity(feedMovieFragment, R.id.fragment_container)
            binding.navView.setCheckedItem(R.id.action_movies)
        }
        setupNavigationView()

        val toggle = ActionBarDrawerToggle(
            this, binding.drawerLayout, binding.toolbar,
            R.string.open_nav_drawer, R.string.close_nav_drawer
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun setupNavigationView() {
        binding.navView.setNavigationItemSelectedListener { item ->
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            val fragment = when (item.itemId) {
                R.id.action_movies -> {
                    viewModel.setType(R.string.menu_movies, NavType.MOVIES)
                    feedMovieFragment
                }
                R.id.action_tv_series -> {
                    viewModel.setType(R.string.menu_tv_series, NavType.TV_SERIES)
                    feedTVShowFragment

                }
                R.id.action_setting -> {
                    viewModel.setType(R.string.menu_setting, NavType.SETTING)
                    settingFragment

                }
                else -> throw RuntimeException("Unknown item to replace fragment")
            }
            invalidateOptionsMenu()
            replaceFragmentInActivity(fragment, R.id.fragment_container)
            true
        }
    }
}