package com.example.theSwitcher.viewmodel

import androidx.lifecycle.ViewModel
import com.example.theSwitcher.model.Room

class RoomsViewModel : ViewModel() {
    private var roomsList: List<Room> = mutableListOf(
        Room("Kitchen"),
        Room("Living room"),
        Room("Master bedroom"),
        Room("Guest's bedroom")
    )

    //returns mock room list
    fun getRoomList(): List<Room> = roomsList

    //to save upon changing fragments
    fun saveRoomList(newRoomList: List<Room>) {
        roomsList = newRoomList
    }
}