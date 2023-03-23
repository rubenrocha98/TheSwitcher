package com.example.theSwitcher.util

import android.os.Build
import android.os.Bundle
import com.example.theSwitcher.model.Room

fun Bundle.getRoom(): Room {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        this.getParcelable(Util.ARGUMENT_ROOM, Room::class.java)!!
    } else {
        this.getParcelable(Util.ARGUMENT_ROOM)!!
    }
}
