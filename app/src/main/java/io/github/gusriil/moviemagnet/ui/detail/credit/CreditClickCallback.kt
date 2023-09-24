package io.github.gusriil.moviemagnet.ui.detail.credit

import android.os.Parcelable

interface CreditClickCallback<T : Parcelable> {
    fun onClick(credit : T)
}