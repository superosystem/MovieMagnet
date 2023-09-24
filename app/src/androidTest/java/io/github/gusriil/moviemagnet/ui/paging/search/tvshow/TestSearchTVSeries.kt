package io.github.gusriil.moviemagnet.ui.paging.search.tvshow

import android.content.Context
import android.content.Intent
import androidx.test.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import io.github.gusriil.moviemagnet.ui.paging.search.BaseSearchActivity
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestSearchTVSeries : BaseSearchActivity() {

    @Rule
    @JvmField
    val activityTestRule: ActivityTestRule<SearchTVShowActivity> =
        object : ActivityTestRule<SearchTVShowActivity>(
            SearchTVShowActivity::class.java
        ) {
            override fun getActivityIntent(): Intent {
                val targetContext: Context =
                    InstrumentationRegistry.getInstrumentation().targetContext
                return Intent(targetContext, SearchTVShowActivity::class.java)
            }
        }
}