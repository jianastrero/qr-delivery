package dev.jianastrero.qr_delivery.state.home

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeState(
    val message: String = "",
    val value: Float = 0.5f
) : Parcelable

