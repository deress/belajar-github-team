package com.dicoding.rosterseagames

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Roster(
    val name: String,
    val description: String,
    val photo: String,
    val cover_photo: String,
    val height : String,
    val weight : String,
    val position : String,
    val birthdate : String
) : Parcelable
