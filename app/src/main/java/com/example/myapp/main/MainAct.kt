package com.example.myapp.main

import com.example.myapp.abs.AbsStateActivity
import com.example.myapp.player.PlayerAct

class MainAct : AbsStateActivity() {


    override fun initializedLayout() {
        //TODO("Not yet implemented")

        //startActivity(PlayerAct.getIntent(this))

        startActivity(PlayerAct.getIntent(this))

    }

    override fun initializedView() {
        //TODO("Not yet implemented")
    }

    override fun initObservable() {
        //TODO("Not yet implemented")
    }
}