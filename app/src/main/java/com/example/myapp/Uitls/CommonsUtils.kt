package com.example.myapp.Uitls

import android.content.Context
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class CommonsUtils {
}

fun String.Log(action: String = "Log :=") {
    android.util.Log.i("===", "$action $this")
}

fun String.toast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}

fun Context.translation(@IdRes id: Int, fragment: Fragment) {
    (this as? FragmentActivity)?.supportFragmentManager?.beginTransaction()?.replace(id, fragment)
        ?.commit()
}