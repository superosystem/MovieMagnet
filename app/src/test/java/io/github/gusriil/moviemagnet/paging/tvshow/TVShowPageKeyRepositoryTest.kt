package io.github.gusriil.moviemagnet.paging.tvshow

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagedList
import com.google.common.collect.Lists
import io.github.gusriil.moviemagnet.LoggingObserver
import io.github.gusriil.moviemagnet.data.response.ItemWrapper
import io.github.gusriil.moviemagnet.data.response.NetworkTVShow
import io.github.gusriil.moviemagnet.domain.model.TVShow
import io.github.gusriil.moviemagnet.data.network.TVShowApi
import io.github.gusriil.moviemagnet.domain.model.SortType.*
import io.github.gusriil.moviemagnet.util.isNetworkAvailable
import io.mockk.every
import io.mockk.mockkStatic
import io.reactivex.Observable
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.anyInt
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executor

@RunWith(MockitoJUnitRunner::class)
class TVShowPageKeyRepositoryTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var api: TVShowApi

    @Mock
    private lateinit var context: Context

    private val networkExecutor = Executor { command -> command.run() }

    private lateinit var tvShow: NetworkTVShow

    @Before
    fun setup() {
        mockkStatic("io.github.gusriil.moviemagnet.util.ContextExtKt")
        every {
            context.isNetworkAvailable()
        } returns true
        tvShow = NetworkTVShow(1, "overview", "date",
                null, null, "title", 6.5)
    }

    @Test
    fun loadTrendingTVShows() {
        val repository = TVShowsPageKeyRepository(api, TRENDING, networkExecutor, context)
        `when`(api.trendingTVSeries(anyInt())).thenReturn(Observable.just(ItemWrapper(Lists.newArrayList(tvShow))))

        with(getObserver(repository).value) {
            assertThat(this, `is`(notNullValue()))
            assertThat(this?.size, `is`(1))
        }
    }

    @Test
    fun loadAiringTodayTVShows() {
        val repository = TVShowsPageKeyRepository(api, NOW_PLAYING, networkExecutor, context)
        `when`(api.airingTodayTVSeries(anyInt())).thenReturn(Observable.just(ItemWrapper(Lists.newArrayList(tvShow))))

        with(getObserver(repository).value) {
            assertThat(this, `is`(notNullValue()))
            assertThat(this?.size, `is`(1))
        }
    }

    @Test
    fun loadMostPopularTVShows() {
        val repository = TVShowsPageKeyRepository(api, MOST_POPULAR, networkExecutor, context)
        `when`(api.popularTVSeries(anyInt())).thenReturn(Observable.just(ItemWrapper(Lists.newArrayList(tvShow))))

        with(getObserver(repository).value) {
            assertThat(this, `is`(notNullValue()))
            assertThat(this?.size, `is`(1))
        }
    }

    @Test
    fun loadHighRatedTVShows() {
        val repository = TVShowsPageKeyRepository(api, HIGHEST_RATED, networkExecutor, context)
        `when`(api.topRatedTVSeries(anyInt())).thenReturn(Observable.just(ItemWrapper(Lists.newArrayList(tvShow))))

        with(getObserver(repository).value) {
            assertThat(this, `is`(notNullValue()))
            assertThat(this?.size, `is`(1))
        }
    }

    @Test
    fun loadOnTheAirTVShows() {
        val repository = TVShowsPageKeyRepository(api, UPCOMING, networkExecutor, context)
        `when`(api.onTheAirTVSeries(anyInt())).thenReturn(Observable.just(ItemWrapper(Lists.newArrayList(tvShow))))

        with(getObserver(repository).value) {
            assertThat(this, `is`(notNullValue()))
            assertThat(this?.size, `is`(1))
        }
    }

    private fun getObserver(repository: TVShowsPageKeyRepository): LoggingObserver<PagedList<TVShow>> {
        val listing = repository.getItems()
        val observer = LoggingObserver<PagedList<TVShow>>()
        listing.pagedList.observeForever(observer)
        return observer
    }
}