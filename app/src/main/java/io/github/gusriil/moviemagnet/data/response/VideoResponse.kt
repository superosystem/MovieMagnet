package io.github.gusriil.moviemagnet.data.response

import com.google.gson.annotations.SerializedName
import io.github.gusriil.moviemagnet.domain.model.Video
import io.github.gusriil.moviemagnet.util.Constants.ID
import io.github.gusriil.moviemagnet.util.Constants.NAME

class VideoResponse(
    @SerializedName(ID)
    val id: String,
    @SerializedName(NAME)
    val name: String,
    @SerializedName("site")
    val site: String,
    @SerializedName("key")
    val videoId: String,
    @SerializedName("type")
    val type: String
)

fun List<VideoResponse>.asDomainModel(): List<Video> =
    map { Video(it.id, it.name, it.site, it.videoId, it.type) }