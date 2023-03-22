package com.example.theSwitcher.model

import java.io.Serializable


data class Room(var roomName: String, var lightOn: Boolean = false): Serializable
