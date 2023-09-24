package io.github.gusriil.moviemagnet.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
enum class SortType : Parcelable {
    TRENDING,
    MOST_POPULAR,
    HIGHEST_RATED,
    UPCOMING,
    NOW_PLAYING
}