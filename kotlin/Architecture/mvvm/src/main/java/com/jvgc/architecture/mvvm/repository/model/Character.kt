package com.jvgc.architecture.mvvm.repository.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(
    val name: String,
    val species: String,
    val gender: String,
    val house: String?,
    val dateOfBirth: String?,
    val yearOfBirth: String?,
    val ancestry: String?,
    val eyeColour: String?,
    val hairColour: String,
    val wand: Wand,
    val patronus: String?,
    val hogwartsStudent: Boolean,
    val hogwartsStaff: Boolean,
    val actor: String,
    val alive: Boolean,
    val image: String
) : Parcelable
