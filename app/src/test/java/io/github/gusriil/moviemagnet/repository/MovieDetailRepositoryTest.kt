package io.github.gusriil.moviemagnet.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.github.gusriil.moviemagnet.TestRxJavaRule
import io.github.gusriil.moviemagnet.data.response.NetworkCast
import io.github.gusriil.moviemagnet.data.response.NetworkCreditWrapper
import io.github.gusriil.moviemagnet.data.response.VideoResponse
import io.github.gusriil.moviemagnet.data.response.VideoWrapper
import io.github.gusriil.moviemagnet.data.network.MovieApi
import io.reactivex.Single
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieDetailRepositoryTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    var rxJavaRule: TestRule = TestRxJavaRule()

    @Mock
    private lateinit var movieApi: MovieApi

    @Test
    fun loadTrailersAndCredits() {
        val trailers = VideoWrapper(listOf(VideoResponse("id", "", "", "", "")))
        val creditWrapper = NetworkCreditWrapper(listOf(NetworkCast("", "", null, 1)), listOf())
        `when`(movieApi.movieTrailers(anyInt())).thenReturn(Single.just(trailers))
        `when`(movieApi.movieCredit(anyInt())).thenReturn(Single.just(creditWrapper))

        val repository = MovieDetailRepositoryImpl(movieApi)

        assertThat(repository.getMovieTrailers(anyInt()).blockingGet().size, `is`(1))
        assertThat(repository.getMovieCredit(anyInt()).cast.blockingGet().size, `is`(1))
    }

    @Test
    fun errorLoadTrailers() {
        val error = "errorMsg"
        `when`(movieApi.movieTrailers(anyInt())).thenReturn(Single.error(Exception(error)))

        val repository = MovieDetailRepositoryImpl(movieApi)
        repository.getMovieTrailers(anyInt()).test().assertErrorMessage(error)
    }

    @Test
    fun errorLoadCredits() {
        val error = "errorMsg"
        `when`(movieApi.movieCredit(anyInt())).thenReturn(Single.error(Exception(error)))

        val repository = MovieDetailRepositoryImpl(movieApi)
        repository.getMovieCredit(anyInt()).cast.test().assertErrorMessage(error)
    }
}