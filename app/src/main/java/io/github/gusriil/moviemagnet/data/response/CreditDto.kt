package io.github.gusriil.moviemagnet.data.response

import com.google.gson.annotations.SerializedName
import io.github.gusriil.moviemagnet.domain.model.Cast
import io.github.gusriil.moviemagnet.domain.model.Crew
import io.github.gusriil.moviemagnet.util.Constants.BASE_WIDTH_342_PATH
import io.github.gusriil.moviemagnet.util.Constants.ID
import io.github.gusriil.moviemagnet.util.Constants.NAME

class NetworkCast(
    @SerializedName("character")
    val role: String,
    @SerializedName(NAME)
    val name: String,
    @SerializedName(PROFILE_PATH)
    val profilePath: String?,
    @SerializedName(ID)
    val id: Int
)

class NetworkCrew(
    @SerializedName("job")
    val role: String,
    @SerializedName(NAME)
    val name: String,
    @SerializedName(PROFILE_PATH)
    val profilePath: String?,
    @SerializedName(ID)
    val id: String
)

fun List<NetworkCast>.asCastDomainModel(): List<Cast> = map {
    Cast(it.role, it.name, it.profilePath?.let { profilePath ->
        String.format(
            BASE_WIDTH_342_PATH,
            profilePath
        )
    }, it.id)
}

fun List<NetworkCrew>.asCrewDomainModel(): List<Crew> = map {
    Crew(it.role, it.name, it.profilePath?.let { profilePath ->
        String.format(
            BASE_WIDTH_342_PATH,
            profilePath
        )
    }, it.id)
}

private const val PROFILE_PATH = "profile_path"