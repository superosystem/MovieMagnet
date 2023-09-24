package io.github.gusriil.moviemagnet.repository

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.github.gusriil.moviemagnet.TestCoroutineRule
import io.github.gusriil.moviemagnet.data.response.ItemWrapper
import io.github.gusriil.moviemagnet.data.network.TVShowApi
import io.github.gusriil.moviemagnet.util.Resource
import io.github.gusriil.moviemagnet.util.isNetworkAvailable
import io.mockk.every
import io.mockk.mockkStatic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class TVShowFeedRepositoryTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var context: Context

    @Mock
    private lateinit var tvShowApi: TVShowApi

    @Before
    fun setup() {
        mockkStatic("io.github.gusriil.moviemagnet.util.ContextExtKt")
        every {
            context.isNetworkAvailable()
        } returns true
    }

    @Test
    fun `test Api Succeeds`() {
        testCoroutineRule.runBlockingTest {
            `when`(tvShowApi.trendingTVSeries()).thenReturn(ItemWrapper(emptyList()))
            `when`(tvShowApi.popularTVSeries()).thenReturn(ItemWrapper(emptyList()))
            `when`(tvShowApi.onTheAirTVSeries()).thenReturn(ItemWrapper(emptyList()))
            `when`(tvShowApi.topRatedTVSeries()).thenReturn(ItemWrapper(emptyList()))
            `when`(tvShowApi.airingTodayTVSeries()).thenReturn(ItemWrapper(emptyList()))

            val repository = TVShowFeedRepository(context, Dispatchers.Main, tvShowApi)

            assertThat(repository.result.first(), `is`(Resource.Loading))

            val result = (repository.result.last() as Resource.Success).data

            assertThat(result[0].feeds, `is`(emptyList()))
            assertThat(result[1].feeds, `is`(emptyList()))
            assertThat(result[2].feeds, `is`(emptyList()))
            assertThat(result[3].feeds, `is`(emptyList()))
            assertThat(result[4].feeds, `is`(emptyList()))
        }
    }

    @Test
    fun `test Fetch tvShows Fails`() {
        val errorMsg = "error message"
        `when`(context.getString(anyInt())).thenReturn(errorMsg)

        testCoroutineRule.runBlockingTest {

            val repository = TVShowFeedRepository(context, Dispatchers.Main, tvShowApi)

            assertThat(repository.result.first(), `is`(Resource.Loading))
            assertThat(repository.result.last(), `is`(Resource.Error(errorMsg)))
        }
    }
}