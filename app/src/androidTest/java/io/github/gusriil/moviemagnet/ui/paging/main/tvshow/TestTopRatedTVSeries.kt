package io.github.gusriil.moviemagnet.ui.paging.main.tvshow

import android.content.Context
import android.content.Intent
import androidx.test.InstrumentationRegistry
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import io.github.gusriil.moviemagnet.ui.paging.main.BaseMainActivity
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class TestTopRatedTVSeries : BaseMainActivity() {

    @Rule
    @JvmField
    val activityTestRule: ActivityTestRule<HighRateTVShowActivity> =
        object : ActivityTestRule<HighRateTVShowActivity>(
            HighRateTVShowActivity::class.java
        ) {
            override fun getActivityIntent(): Intent {
                val targetContext: Context =
                    InstrumentationRegistry.getInstrumentation().targetContext
                return Intent(targetContext, HighRateTVShowActivity::class.java)
            }
        }

    override val title: String
        get() = "Top Rated TV Series"
}