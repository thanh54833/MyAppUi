package com.example.myapp.player

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.myapp.R
import com.example.myapp.abs.AbsStateActivity
import com.example.myapp.contact.type.PageType
import com.example.myapp.databinding.PlayerActBinding
import com.google.android.material.snackbar.Snackbar
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


        snackbar("message", true)
    }


    private fun initView() {


    }

    private fun initListener() {
        binding.btn.setOnClickListener {

        }

        binding.bottomBar.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelect(pos: Int): Boolean {
                snackbar("On Click Btn ...")
                when (pos) {
                    PageType.MUSIC -> {
                        binding.bottomBar.setBackgroundColorBar(Color.RED)
                        setSelectedPage(PageType.MUSIC)
                    }
                    PageType.LIST_LIKE -> {
                        binding.bottomBar.setBackgroundColorBar(Color.GRAY)
                        setSelectedPage(PageType.LIST_LIKE)
                    }
                    PageType.SETTING -> {
                        binding.bottomBar.setBackgroundColorBar(Color.BLUE)
                        setSelectedPage(PageType.SETTING)
                    }
                }
                return false
            }
        })


    }

    private fun initNavigates() {

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

