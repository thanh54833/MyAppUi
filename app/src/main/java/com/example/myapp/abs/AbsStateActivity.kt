package com.example.myapp.abs

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.commons.sharepreference.intPreference
import com.example.commons.snackbar.SnackBarView
import com.example.myapp.R
import com.example.myapp.contact.type.PageType
import com.example.myapp.contact.type.ThemesType
import com.google.android.material.snackbar.Snackbar
import kotlin.properties.Delegates

abstract class AbsStateActivity : AppCompatActivity() {
    private var themesMusic: Int by intPreference(THEMES_TYPE_MUSIC, ThemesType.LIGHT)
    private var themesFavorite: Int by intPreference(THEMES_TYPE_FAVORITE, ThemesType.DARK)
    private var themesSetting: Int by intPreference(THEMES_TYPE_SETTING, ThemesType.PINK)

    private var pageCurrent: Int by intPreference(PAGE_CURRENT, PageType.MUSIC)
    private var contentUi: View? = null
    private lateinit var result: () -> Unit

    private var pageType: Int by Delegates.observable(PageType.MUSIC) { _, _, _newPage ->
        pageCurrent = _newPage
        applyThemes(_newPage)
    }

    //public var toast: String by ShowToast()
    fun toast(message: String) {
        android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()
    }

    fun snackbar(message: String) {
        contentUi?.let {
            Snackbar.make(it, message, Snackbar.LENGTH_LONG).show()
        }
    }

    fun snackbar(message: String, isCustom: Boolean = true) {
        contentUi?.let { _view ->
            val mSnackbar = Snackbar.make(_view, "", Snackbar.LENGTH_LONG)
            (mSnackbar.view as? Snackbar.SnackbarLayout)?.apply {
                findViewById<View>(R.id.snackbar_text).visibility = View.INVISIBLE
                findViewById<View>(R.id.snackbar_action).visibility = View.INVISIBLE
                val snackView: View = SnackBarView
                    .onCreate(_view.context)
                    .setMessage(message).build()
                addView(snackView, 0)
                mSnackbar.setDuration(800).show()
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //themesMusic = ThemesType.LIGHT
        //themesFavorite = ThemesType.DARK
        //themesSetting = ThemesType.PINK
        //pageCurrent = PageType.MUSIC

        handleTheme(pageCurrent)
        initializedLayout()
        initImportant({ _stateView ->

        }, { _contentView ->
            this.contentUi = _contentView
        }, { _inVisiable ->

        })
        initializedView()
        initObservable()
    }

    abstract fun initImportant(
        setMultipleStateView: (view: View) -> Unit,
        setContentView: (view: View) -> Unit,
        setInVisible: (views: MutableList<View>) -> Unit
    )

    abstract fun initializedLayout()
    abstract fun initializedView()
    abstract fun initObservable()

    fun setSelectedPage(pageType: Int) {
        this.pageType = pageType
    }

    private fun applyThemes(_styleType: Int) {
        updateTheme(_styleType)
        recreateActivity()
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

    private fun recreateActivity() {

        //recreate()

        //val intent = intent
        //intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        //finish()
        //overridePendingTransition(0, 0)
        //startActivity(intent)
        //overridePendingTransition(0, 0)
    }

    companion object {
        const val THEMES_TYPE_MUSIC = "THEMES_TYPE_MUSIC"
        const val THEMES_TYPE_FAVORITE = "THEMES_TYPE_FAVORITE"
        const val THEMES_TYPE_SETTING = "THEMES_TYPE_SETTING"
        const val PAGE_CURRENT = "PAGE_CURRENT"
    }
}