package io.github.gusriil.moviemagnet.repository

import io.github.gusriil.moviemagnet.data.network.MovieApi
import io.github.gusriil.moviemagnet.data.response.asCreditWrapper
import io.github.gusriil.moviemagnet.data.response.asDomainModel
import io.github.gusriil.moviemagnet.domain.repository.MovieDetailRepository
import io.github.gusriil.moviemagnet.domain.model.CreditWrapper
import io.github.gusriil.moviemagnet.domain.model.Video
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDetailRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi
) : MovieDetailRepository {

    override fun getMovieTrailers(movieId: Int): Single<List<Video>> =
        movieApi.movieTrailers(movieId).map { it.videos.asDomainModel() }

    override fun getMovieCredit(movieId: Int): CreditWrapper =
         movieApi.movieCredit(movieId).asCreditWrapper()
}