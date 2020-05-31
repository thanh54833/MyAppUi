package com.example.myapp.abs

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.commons.sharepreference.intPreference
import com.example.commons.snackbar.SnackBarView
import com.example.myapp.R
import com.example.myapp.config.AppConfig
import com.example.myapp.contact.config.AppMode
import com.example.myapp.contact.type.PageType
import com.example.myapp.contact.type.ThemesType
import com.example.myapp.test.act.TestAct
import com.example.myapp.test.room.DatabaseHelperImpl
import com.google.android.material.snackbar.Snackbar
import kotlin.properties.Delegates

abstract class AbsStateActivity : AppCompatActivity() {
    private var themesMusic: Int by intPreference(THEMES_TYPE_MUSIC, ThemesType.LIGHT)
    private var themesFavorite: Int by intPreference(THEMES_TYPE_FAVORITE, ThemesType.DARK)
    private var themesSetting: Int by intPreference(THEMES_TYPE_SETTING, ThemesType.PINK)
    private var pageCurrent: Int by intPreference(PAGE_CURRENT, PageType.MUSIC)
    private var contentUi: View? = null
    private lateinit var result: () -> Unit
    private var isUpdateOnlyTopBar: Boolean = true

    private var pageType: Int by Delegates.observable(PageType.MUSIC) { _, _, _newPage ->
        pageCurrent = _newPage
        applyThemes(_newPage)
    }

    fun toast(message: String) {
        android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("RestrictedApi")
    fun snackbar(message: String) {
        contentUi?.let { _view ->
            val mSnack = Snackbar.make(_view, "", Snackbar.LENGTH_LONG)
            (mSnack.view as? Snackbar.SnackbarLayout)?.apply {
                findViewById<View>(R.id.snackbar_text).visibility = View.INVISIBLE
                findViewById<View>(R.id.snackbar_action).visibility = View.INVISIBLE
                background = ContextCompat.getDrawable(
                    context,
                    R.drawable.bg_snackbar_default
                )
                val snackView: View = SnackBarView
                    .onCreate(_view.context)
                    .setMessage(message).build()
                addView(snackView, 0)
                mSnack.setDuration(800).show()
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleTheme(pageCurrent)
        initializedLayout()
        initImportant({ _stateView ->

        }, { _contentView ->
            this.contentUi = _contentView
        }, { _inVisiable ->

        })
        initializedView()
        initObservable()
        initTestView()
    }


    abstract fun initImportant(
        setMultipleStateView: (view: View) -> Unit,
        setContentView: (view: View) -> Unit,
        setInVisible: (views: MutableList<View>) -> Unit
    )

    abstract fun initializedLayout()
    abstract fun initializedView()
    abstract fun initObservable()


    private fun initTestView() {
        when (AppConfig.APP_MODE) {
            AppMode.TEST -> {
                if (!TextUtils.equals(AppConfig.ACTIVITY_TEST.name, this.javaClass.name)) {
                    val intent = Intent(this, AppConfig.ACTIVITY_TEST)
                    startActivity(intent)
                }
            }
            AppMode.REALEASE -> {
                
            }
        }
    }

    fun setSelectedPage(pageType: Int, isUpdateOnlyTopBar: Boolean = true) {
        this.pageType = pageType
        this.isUpdateOnlyTopBar = isUpdateOnlyTopBar
    }

    private fun applyThemes(_styleType: Int) {
        if (isUpdateOnlyTopBar) {
            setColorTopBar(_styleType)
        } else {
            updateTheme(_styleType)
            recreateActivity()
        }
    }

    private fun handleTheme(pageType: Int) {
        when (pageType) {
            PageType.MUSIC -> {
                updateTheme(themesMusic)
            }
            PageType.LIST_LIKE -> {
                updateTheme(themesFavorite)
            }
            PageType.SETTING -> {
                updateTheme(themesSetting)
            }
        }
    }

    @SuppressLint("ResourceType")
    private fun setColorTopBar(_styleType: Int) {
        when (_styleType) {
            ThemesType.LIGHT -> {
                updateTopBar(R.color.primaryColorDark_blue)
            }
            ThemesType.DARK -> {
                updateTopBar(R.color.primaryColorDark_red)
            }
            ThemesType.PINK -> {
                updateTopBar(R.color.colorPrimary)
            }
        }
    }

    private fun updateTheme(_styleType: Int) {
        when (_styleType) {
            ThemesType.LIGHT -> {
                theme.applyStyle(R.style.AppTheme_Light, true)
            }
            ThemesType.DARK -> {
                theme.applyStyle(R.style.AppTheme_Dark, true)
            }
            ThemesType.PINK -> {
                theme.applyStyle(R.style.AppTheme_Pink, true)
            }
        }
    }

    fun setMusicThemes(@ThemesType themes: Int) {
        this.themesMusic = themes
    }

    fun setFavoriteThemes(@ThemesType themes: Int) {
        this.themesFavorite = themes
    }

    fun setSettingThemes(@ThemesType themes: Int) {
        this.themesSetting = themes
    }

    @SuppressLint("ResourceType")
    fun updateTopBar(@IdRes ids: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = resources.getColor(ids, this.theme)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, ids)
        }
    }

    private fun recreateActivity() {
        //recreate()
        val intent = intent
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        finish()
        overridePendingTransition(0, 0)
        startActivity(intent)
        overridePendingTransition(0, 0)
    }


    companion object {
        const val THEMES_TYPE_MUSIC = "THEMES_TYPE_MUSIC"
        const val THEMES_TYPE_FAVORITE = "THEMES_TYPE_FAVORITE"
        const val THEMES_TYPE_SETTING = "THEMES_TYPE_SETTING"
        const val PAGE_CURRENT = "PAGE_CURRENT"
    }
}