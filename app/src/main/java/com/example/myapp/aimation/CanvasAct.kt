package com.example.myapp.aimation

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.graphics.Typeface
import androidx.databinding.DataBindingUtil
import com.example.myapp.R
import com.example.myapp.abs.AbsStateActivity
import com.example.myapp.databinding.CanvasActBinding

class CanvasAct : AbsStateActivity() {
    lateinit var binding: CanvasActBinding


    override fun initializedLayout() {
        //TODO("Not yet implemented")
        binding = DataBindingUtil.setContentView(this@CanvasAct, R.layout.canvas_act)
        initView()

    }

    override fun initializedView() {
        //TODO("Not yet implemented")
    }

    private fun initView() {


    }

    override fun initObservable() {
        //TODO("Not yet implemented")
    }

    companion object {
        @JvmStatic
        fun getIntent(context: Context): Intent {
            return Intent(context, CanvasAct::class.java).apply {

            }
        }
    }

}