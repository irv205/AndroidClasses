package com.irv205.testproject.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Song(
    val name: String,
    val time: Long,
    val type: Int,
    val gen: String
): Parcelable
