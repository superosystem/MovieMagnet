package io.github.gusriil.moviemagnet.domain.repository

import io.github.gusriil.moviemagnet.domain.model.CreditWrapper
import io.github.gusriil.moviemagnet.domain.model.Video
import io.reactivex.Single

interface MovieDetailRepository {

    fun getMovieTrailers(movieId: Int): Single<List<Video>>

    fun getMovieCredit(movieId: Int): CreditWrapper
}