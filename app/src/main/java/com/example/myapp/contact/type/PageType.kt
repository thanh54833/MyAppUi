package com.example.myapp.contact.type

import androidx.annotation.IntDef
import com.example.myapp.contact.type.PageType.Companion.LIST_LIKE
import com.example.myapp.contact.type.PageType.Companion.MUSIC
import com.example.myapp.contact.type.PageType.Companion.SETTING

@IntDef(MUSIC, LIST_LIKE, SETTING)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
annotation class PageType {
    companion object {
        const val MUSIC = 0
        const val LIST_LIKE = 1
        const val SETTING = 2
    }
}