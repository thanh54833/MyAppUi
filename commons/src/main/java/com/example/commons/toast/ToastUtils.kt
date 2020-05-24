package com.example.commons.toast

import android.content.Context
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun ShowToast(message: String? = ""): ReadWriteProperty<Context, String> = ToastProperty(message)
class ToastProperty(var message: String?) : ReadWriteProperty<Context, String> {
    override fun getValue(thisRef: Context, property: KProperty<*>): String {
        return message ?: ""
    }
    override fun setValue(thisRef: Context, property: KProperty<*>, value: String) {
        Log.i("===", "=== message :== " + message)

        if (!TextUtils.isEmpty(message)) {
            Toast.makeText(thisRef, message, Toast.LENGTH_SHORT).show()
        }
    }
}