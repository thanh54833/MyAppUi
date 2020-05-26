package com.example.myapp.test.act

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.myapp.R
import com.example.myapp.abs.AbsStateActivity
import com.example.myapp.databinding.TestActBinding

class TestAct : AbsStateActivity() {
    lateinit var binding: TestActBinding
    override fun initImportant(
        setMultipleStateView: (view: View) -> Unit,
        setContentView: (view: View) -> Unit,
        setInVisible: (views: MutableList<View>) -> Unit
    ) {
        //TODO("Not yet implemented")
    }

    override fun initializedLayout() {
        //TODO("Not yet implemented")
        binding = DataBindingUtil.setContentView(this@TestAct, R.layout.test_act)
    }

    override fun initializedView() {
        //TODO("Not yet implemented")
        initView()
    }

    private fun initView() {

        //Todo : tai lieu room ...
        //https://medium.com/mindorks/using-room-database-android-jetpack-675a89a0e942

    }

    override fun initObservable() {
        //TODO("Not yet implemented")
    }

    companion object {
        @JvmStatic
        fun getIntent(context: Context): Intent {
            return Intent(context, TestAct::class.java).apply {

            }
        }
    }

}