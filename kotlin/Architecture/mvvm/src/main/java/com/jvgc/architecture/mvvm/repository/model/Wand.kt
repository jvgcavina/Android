package com.jvgc.architecture.mvvm.repository.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Wand(
    val wood: String?,
    val core: String?,
    val length: String?
) : Parcelable
