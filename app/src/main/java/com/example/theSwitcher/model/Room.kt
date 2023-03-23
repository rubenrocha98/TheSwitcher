package com.example.theSwitcher.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Room(var roomName: String, var lightOn: Boolean = false) : Parcelable
