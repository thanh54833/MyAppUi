package com.example.myapp.player

import android.content.Context
import android.content.Intent
import androidx.databinding.DataBindingUtil
import com.example.myapp.R
import com.example.myapp.abs.AbsStateActivity
import com.example.myapp.databinding.PlayerActBinding

class PlayerAct : AbsStateActivity() {
    lateinit var binding: PlayerActBinding

    override fun initializedLayout() {
        binding = DataBindingUtil.setContentView(this@PlayerAct, R.layout.player_act)

    }

    override fun initObservable() {
        initView()

    }

    private fun initView() {

    }

    companion object {
        @JvmStatic
        fun getIntent(context: Context): Intent {
            return Intent(context, PlayerAct::class.java).apply {

            }
        }
    }
}