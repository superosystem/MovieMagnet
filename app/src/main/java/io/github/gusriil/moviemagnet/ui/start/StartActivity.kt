package io.github.gusriil.moviemagnet.ui.start

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import io.github.gusriil.moviemagnet.R
import io.github.gusriil.moviemagnet.ui.feed.FeedActivity
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

class StartActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var inAppUpdateHandler: InAppUpdateHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        lifecycleScope.launchWhenStarted {
            Timber.i("Ensuring app is up to date.")
            if (inAppUpdateHandler.ensureUpdated()) {
                Timber.i("App is up to date.")
                startMainActivity()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        lifecycleScope.launchWhenStarted {
            Timber.i("Completing update")
            when (inAppUpdateHandler.completeUpdate(requestCode, resultCode)) {
                InAppUpdateHandler.CompletionResult.INCORRECT_REQUEST_CODE -> Unit
                InAppUpdateHandler.CompletionResult.OK -> startMainActivity()
                InAppUpdateHandler.CompletionResult.BLOCKED -> finish()
            }
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this, FeedActivity::class.java)
        startActivity(intent)
        finish()
    }
}