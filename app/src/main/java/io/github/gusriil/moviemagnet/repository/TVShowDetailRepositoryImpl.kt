package io.github.gusriil.moviemagnet.repository

import io.github.gusriil.moviemagnet.data.network.TVShowApi
import io.github.gusriil.moviemagnet.data.response.asCreditWrapper
import io.github.gusriil.moviemagnet.data.response.asDomainModel
import io.github.gusriil.moviemagnet.domain.repository.TVShowDetailRepository
import io.github.gusriil.moviemagnet.domain.model.CreditWrapper
import io.github.gusriil.moviemagnet.domain.model.Video
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TVShowDetailRepositoryImpl @Inject constructor(
    private val tvShowApi: TVShowApi
) : TVShowDetailRepository {

    override fun getTVShowTrailers(tvId: Int): Single<List<Video>> =
        tvShowApi.tvTrailers(tvId).map { it.videos.asDomainModel() }

    override fun getTVShowCredit(tvId: Int): CreditWrapper =
        tvShowApi.tvCredit(tvId).asCreditWrapper()
}