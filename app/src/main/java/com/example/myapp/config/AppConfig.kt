package com.example.myapp.config

import com.example.myapp.contact.config.AppMode
import com.example.myapp.test.room.TestRoomCoroutinesAct


object AppConfig {
    const val APP_MODE = AppMode.TEST
    val ACTIVITY_TEST = TestRoomCoroutinesAct::class.java
    
}



