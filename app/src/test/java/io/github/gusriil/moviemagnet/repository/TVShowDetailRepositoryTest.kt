package io.github.gusriil.moviemagnet.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.github.gusriil.moviemagnet.TestRxJavaRule
import io.github.gusriil.moviemagnet.data.response.NetworkCast
import io.github.gusriil.moviemagnet.data.response.NetworkCreditWrapper
import io.github.gusriil.moviemagnet.data.response.VideoResponse
import io.github.gusriil.moviemagnet.data.response.VideoWrapper
import io.github.gusriil.moviemagnet.data.network.TVShowApi
import io.reactivex.Single
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TVShowDetailRepositoryTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    var rxJavaRule: TestRule = TestRxJavaRule()

    @Mock
    private lateinit var tvShowApi: TVShowApi

    @Test
    fun loadTrailersAndCredits() {
        val trailers = VideoWrapper(listOf(VideoResponse("id", "", "", "", "")))
        val creditWrapper = NetworkCreditWrapper(listOf(NetworkCast("", "", null, 1)), listOf())
        `when`(tvShowApi.tvTrailers(anyInt())).thenReturn(Single.just(trailers))
        `when`(tvShowApi.tvCredit(anyInt())).thenReturn(Single.just(creditWrapper))

        val repository = TVShowDetailRepositoryImpl(tvShowApi)

        Assert.assertThat(repository.getTVShowTrailers(anyInt()).blockingGet().size, `is`(1))
        Assert.assertThat(repository.getTVShowCredit(anyInt()).cast.blockingGet().size, `is`(1))
    }

    @Test
    fun errorLoadTrailers() {
        val error = "errorMsg"
        `when`(tvShowApi.tvTrailers(anyInt())).thenReturn(Single.error(Exception(error)))

        val repository = TVShowDetailRepositoryImpl(tvShowApi)
        repository.getTVShowTrailers(anyInt()).test().assertErrorMessage(error)
    }

    @Test
    fun errorLoadCredits() {
        val error = "errorMsg"
        `when`(tvShowApi.tvCredit(anyInt())).thenReturn(Single.error(Exception(error)))

        val repository = TVShowDetailRepositoryImpl(tvShowApi)
        repository.getTVShowCredit(anyInt()).cast.test().assertErrorMessage(error)
    }
}