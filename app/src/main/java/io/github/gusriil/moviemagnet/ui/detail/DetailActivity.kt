package io.github.gusriil.moviemagnet.ui.detail

import android.view.MenuItem
import io.github.gusriil.moviemagnet.ui.BaseDetailActivity

abstract class DetailActivity : BaseDetailActivity() {

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