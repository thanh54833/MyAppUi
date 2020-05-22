package com.example.myapp.player

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.databinding.DataBindingUtil
import com.example.myapp.R
import com.example.myapp.Uitls.Log
import com.example.myapp.abs.AbsStateActivity
import com.example.myapp.contact.type.PageType
import com.example.myapp.databinding.PlayerActBinding
import me.ibrahimsn.lib.OnItemSelectedListener

class PlayerAct : AbsStateActivity() {
    lateinit var binding: PlayerActBinding

    override fun initializedLayout() {
        binding = DataBindingUtil.setContentView(this@PlayerAct, R.layout.player_act)

    }


    override fun initializedView() {
        initView()

        initNavigates()
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

