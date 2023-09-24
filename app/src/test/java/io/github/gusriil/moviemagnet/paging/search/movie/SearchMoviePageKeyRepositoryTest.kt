package io.github.gusriil.moviemagnet.paging.search.movie

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagedList
import com.google.common.collect.Lists
import io.github.gusriil.moviemagnet.LoggingObserver
import io.github.gusriil.moviemagnet.data.response.ItemWrapper
import io.github.gusriil.moviemagnet.data.response.NetworkMovie
import io.github.gusriil.moviemagnet.domain.model.Movie
import io.github.gusriil.moviemagnet.data.network.MovieApi
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
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executor

@RunWith(MockitoJUnitRunner::class)
class SearchMoviePageKeyRepositoryTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var api: MovieApi

    @Mock
    private lateinit var context: Context

    private val networkExecutor = Executor { command -> command.run() }

    private lateinit var movie: NetworkMovie

    @Before
    fun setup() {
        mockkStatic("io.github.gusriil.moviemagnet.util.ContextExtKt")
        every {
            context.isNetworkAvailable()
        } returns true
        movie = NetworkMovie(1, "overview", "date",
                null, null, "title", 6.5)
    }

    @Test
    fun searchMovies() {
        val repository = SearchMoviePageKeyRepository(api, "", networkExecutor, context)
        `when`(api.searchItems(anyInt(), anyString())).thenReturn(Observable.just(ItemWrapper(Lists.newArrayList(movie))))

        val listing = repository.getItems()
        val observer = LoggingObserver<PagedList<Movie>>()
        listing.pagedList.observeForever(observer)

        with(observer.value) {
            assertThat(this, `is`(notNullValue()))
            assertThat(this?.size, `is`(1))
        }
    }
}