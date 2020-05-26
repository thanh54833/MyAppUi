package com.example.myapp.player

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.myapp.R
import com.example.myapp.Uitls.translation
import com.example.myapp.abs.AbsStateActivity
import com.example.myapp.contact.type.PageType
import com.example.myapp.databinding.PlayerActBinding
import com.example.myapp.player.Navigates.fragment.FavoriteFr
import com.example.myapp.player.Navigates.fragment.MusicFr
import com.example.myapp.player.Navigates.fragment.SettingFr
import me.ibrahimsn.lib.OnItemSelectedListener

class PlayerAct : AbsStateActivity() {
    lateinit var binding: PlayerActBinding

    override fun initImportant(
        setMultipleStateView: (view: View) -> Unit,
        setContentView: (view: View) -> Unit,
        setInVisible: (views: MutableList<View>) -> Unit
    ) {
        setContentView.invoke(binding.contentLayout)
    }

    override fun initializedLayout() {
        binding = DataBindingUtil.setContentView(this@PlayerAct, R.layout.player_act)

        // init oncreate ...
        //Derived(BaseImpl("message...")).print()
        //Example().value = " Thanh thanh"
        //Toast.makeText(this@PlayerAct, Example().value, Toast.LENGTH_SHORT).show()
        //ToastV2("message thanh thanh ...").message

    }

    override fun initializedView() {
        initView()
        initListener()
        initNavigates()
    }


    private fun initView() {



    }

    private fun initListener() {
        binding.btn.setOnClickListener {

        }

        binding.bottomBar.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelect(pos: Int): Boolean {
                //snackbar("On Click Btn ...")
                //snackbar("message")

                when (pos) {
                    PageType.MUSIC -> {
                        binding.bottomBar.setBackgroundColorBar(Color.RED)
                        setSelectedPage(PageType.MUSIC, true)
                        translation(binding.contentLayout.id, MusicFr())
                    }
                    PageType.LIST_LIKE -> {
                        binding.bottomBar.setBackgroundColorBar(Color.GRAY)
                        setSelectedPage(PageType.LIST_LIKE, true)
                        translation(binding.contentLayout.id, FavoriteFr())
                    }
                    PageType.SETTING -> {
                        binding.bottomBar.setBackgroundColorBar(Color.BLUE)
                        setSelectedPage(PageType.SETTING, true)
                        translation(binding.contentLayout.id, SettingFr())
                    }
                }
                return false
            }
        })
    }

    private fun initNavigates() {
        //binding.navigateView
    }
    override fun initObservable() {

    }

    companion object {
        @JvmStatic
        fun getIntent(context: Context): Intent {
            return Intent(context, PlayerAct::class.java).apply {

            }
        }
    }
}

