package io.github.gusriil.moviemagnet.ui.paging

import android.os.Parcelable

interface TmdbClickCallback<T : Parcelable> {
    fun onClick(t: T)
}