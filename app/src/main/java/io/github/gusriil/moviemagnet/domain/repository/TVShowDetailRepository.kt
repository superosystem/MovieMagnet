package io.github.gusriil.moviemagnet.domain.repository

import io.github.gusriil.moviemagnet.domain.model.CreditWrapper
import io.github.gusriil.moviemagnet.domain.model.Video
import io.reactivex.Single

interface TVShowDetailRepository {

    fun getTVShowTrailers(tvId: Int): Single<List<Video>>

    fun getTVShowCredit(tvId: Int): CreditWrapper
}