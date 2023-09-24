package io.github.gusriil.moviemagnet.ui.paging.main

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import io.github.gusriil.moviemagnet.R
import io.github.gusriil.moviemagnet.databinding.ActivityMainBinding
import io.github.gusriil.moviemagnet.domain.model.TmdbItem
import io.github.gusriil.moviemagnet.ui.BaseNavTypeActivity
import io.github.gusriil.moviemagnet.util.addFragmentToActivity
import io.github.gusriil.moviemagnet.util.setupActionBar

abstract class MainActivity<T: TmdbItem> : BaseNavTypeActivity() {

    private lateinit var binding: ActivityMainBinding

    protected abstract val fragment: BaseItemFragment<T>

    protected abstract val screenTitle: String

    override val toolbar: Toolbar
        get() = binding.toolbar

    override val networkStatusLayout: View
        get() = binding.networkStatusLayout

    override val textViewNetworkStatus: TextView
        get() = binding.textViewNetworkStatus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActionBar(binding.toolbar) {
            setDisplayHomeAsUpEnabled(true)
        }
        title = screenTitle
        if (savedInstanceState == null) {
            addFragmentToActivity(fragment, R.id.fragment_container)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}