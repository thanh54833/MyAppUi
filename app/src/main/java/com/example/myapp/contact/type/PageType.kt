package com.example.myapp.contact.type

import androidx.annotation.IntDef
import com.example.myapp.contact.type.PageType.Companion.LIST_LIKE
import com.example.myapp.contact.type.PageType.Companion.MUSIC
import com.example.myapp.contact.type.PageType.Companion.SETTING
import com.example.myapp.contact.type.ThemesType.Companion.DARK
import com.example.myapp.contact.type.ThemesType.Companion.LIGHT

@IntDef(MUSIC, LIST_LIKE, SETTING)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
annotation class PageType {
    companion object {
        const val MUSIC = 0
        const val LIST_LIKE = 1
        const val SETTING = 2
    }
}


@IntDef(LIGHT, DARK)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
annotation class ThemesType {
    companion object {
        const val LIGHT = 0
        const val DARK = 1
        const val PINK = 2
    }
}