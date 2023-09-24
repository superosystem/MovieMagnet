package io.github.gusriil.moviemagnet.data.response

import com.google.gson.annotations.SerializedName
import io.github.gusriil.moviemagnet.domain.model.CreditWrapper
import io.reactivex.Single

class ItemWrapper<T : NetworkTmdbItem>(
    @SerializedName("results")
    val items: List<T>
)

class VideoWrapper(
    @SerializedName("results")
    val videos: List<VideoResponse>
)

class NetworkCreditWrapper(
    @SerializedName("cast")
    val cast: List<NetworkCast>,
    @SerializedName("crew")
    val crew: List<NetworkCrew>
)

fun Single<NetworkCreditWrapper>.asCreditWrapper(): CreditWrapper {
    val cast = map { it.cast.asCastDomainModel() }
    val crew = map { it.crew.asCrewDomainModel() }
    return CreditWrapper(cast, crew)
}