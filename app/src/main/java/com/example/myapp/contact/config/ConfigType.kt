package com.example.myapp.contact.config

import androidx.annotation.IntDef
import com.example.myapp.contact.config.AppMode.Companion.REALEASE
import com.example.myapp.contact.config.AppMode.Companion.TEST

@IntDef(REALEASE, TEST)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
annotation class AppMode {
    companion object {
        const val TEST = 0
        const val REALEASE = 1
    }
}
