package com.example.myapp.abs

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.commons.sharepreference.intPreference
import com.example.myapp.R
import com.example.myapp.contact.type.ThemesType


abstract class AbsStateActivity : AppCompatActivity() {
    private var styleType: Int by intPreference(THEMES_TYPE, ThemesType.LIGHT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateTheme(styleType)

        initializedLayout()
        initObservable()
    }

    abstract fun initializedLayout()
    abstract fun initializedView()
    abstract fun initObservable()

    fun applyThemes(_styleType: Int) {
        styleType = _styleType

        updateTheme(_styleType)

        recreateActivity()
    }

    private fun updateTheme(_styleType: Int) {
        when (_styleType) {
            ThemesType.LIGHT -> {
                setTheme(R.style.AppTheme_Light)
                theme.applyStyle(R.style.AppTheme_Light, true)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    //TODO : set topbar color...
                    //getWindow().setStatusBarColor(getResources().getColor(R.color.primaryColorDark_blue))
                }
            }
            ThemesType.DARK -> {
                setTheme(R.style.AppTheme_Dark)
                theme.applyStyle(R.style.AppTheme_Dark, true)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    //TODO : set topbar color...
                    //getWindow().setStatusBarColor(getResources().getColor(R.color.primaryColorDark_red))
                }
            }
        }
    }

    open fun recreateActivity() {
        val intent = intent
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        finish()
        overridePendingTransition(0, 0)
        startActivity(intent)
        overridePendingTransition(0, 0)
    }

    companion object {
        const val THEMES_TYPE = "THEMES_TYPE"
    }
}