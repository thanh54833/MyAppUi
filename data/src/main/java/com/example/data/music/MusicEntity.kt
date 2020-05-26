package com.example.data.music

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MusicEntity(
    var name: String = "",
    var single: String = "",
    var time: Long = 0L,
    var timeStart: Long = 0L,
    var isLike: Boolean = false,
    var groupId: String = ""
) : Parcelable