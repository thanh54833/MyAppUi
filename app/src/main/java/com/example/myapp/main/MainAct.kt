package com.example.myapp.main


import android.view.View
import com.example.myapp.abs.AbsStateActivity
import com.example.myapp.player.PlayerAct

class MainAct : AbsStateActivity() {
    override fun initImportant(
        setMultipleStateView: (view: View) -> Unit,
        setContentView: (view: View) -> Unit,
        setInVisible: (views: MutableList<View>) -> Unit
    ) {
        //TODO("Not yet implemented")
    }

    override fun initializedLayout() {
        //startActivity(PlayerAct.getIntent(this))
        startActivity(PlayerAct.getIntent(this))

    }

    override fun initializedView() {

    }

    override fun initObservable() {


    }
}