package com.example.myapp.player

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.view.WindowManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.commons.toast.ShowToast
import com.example.myapp.R
import com.example.myapp.Uitls.Log
import com.example.myapp.abs.AbsStateActivity
import com.example.myapp.contact.type.PageType
import com.example.myapp.contact.type.ThemesType
import com.example.myapp.databinding.PlayerActBinding
import me.ibrahimsn.lib.OnItemSelectedListener
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class PlayerAct : AbsStateActivity() {
    lateinit var binding: PlayerActBinding
    private var toast: String by ShowToast()

    override fun initializedLayout() {
        binding = DataBindingUtil.setContentView(this@PlayerAct, R.layout.player_act)
        // init oncreate ...
        //Derived(BaseImpl("message...")).print()
        //Example().value = " Thanh thanh"
        //Toast.makeText(this@PlayerAct, Example().value, Toast.LENGTH_SHORT).show()
        //ToastV2("message thanh thanh ...").message

        "start PlayerAct".Log()

        binding.btn.setOnClickListener {

            applyThemes(ThemesType.DARK)

            /*theme.applyStyle(R.style.AppTheme_Dark, true)

            recreate()
            recreateActivity()
            binding.invalidateAll()
            recreateActivity()

            toast = "OnClick Btn ..."
            toast = "thanh"*/

        }

    }

    override fun initializedView() {
        initView()
        initListener()
        initNavigates()
    }

    private fun initListener() {
        var isSwitch = false

        /*setTheme(R.style.AppTheme_Dark)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            //TODO : set topbar color...
            //getWindow().setStatusBarColor(getResources().getColor(R.color.primaryColorDark_red))
        }
        recreateActivity()*/


        //binding.btn.setOnClickListener {

        //"thanh on click".Log()

        //delegateToast(" Message cua thanh !..")

        //val number = Number(100)
        //Toast.makeText(this@PlayerAct, "messange :=" + number, Toast.LENGTH_SHORT).show()


        //Todo : change style ...
        /*theme.applyStyle(R.style.AppTheme_Light, true)
        recreateActivity()
        binding.invalidateAll()

        this.recreate()
        this.recreateActivity()*/

        /*if (isSwitch) {
            applyThemes(ThemesType.LIGHT)
        } else {
            applyThemes(ThemesType.DARK)
        }*/


        //isSwitch = !isSwitch
        //}
    }

    private fun initNavigates() {

    }

    override fun initObservable() {

    }

    private fun initView() {
        binding.bottomBar.setBackgroundColorBar(Color.RED)
        binding.bottomBar.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelect(pos: Int): Boolean {
                "onClick".Log()

                when (pos) {
                    PageType.MUSIC -> {
                        binding.bottomBar.setBackgroundColorBar(Color.RED)
                    }
                    PageType.LIST_LIKE -> {
                        binding.bottomBar.setBackgroundColorBar(Color.GRAY)
                    }
                    PageType.SETTING -> {
                        binding.bottomBar.setBackgroundColorBar(Color.BLUE)
                    }
                }

                return false
            }
        })
    }

    companion object {
        @JvmStatic
        fun getIntent(context: Context): Intent {
            return Intent(context, PlayerAct::class.java).apply {

            }
        }
    }
}

