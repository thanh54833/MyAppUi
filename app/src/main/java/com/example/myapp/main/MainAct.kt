package com.example.myapp.main

import com.example.myapp.abs.AbsStateActivity
import com.example.myapp.aimation.CanvasAct
import com.example.myapp.player.PlayerAct

class MainAct : AbsStateActivity() {+
    override fun initializedLayout() {
        //TODO("Not yet implemented")

        //startActivity(PlayerAct.getIntent(this))

        startActivity(CanvasAct.getIntent(this))

    }

    override fun initObservable() {
        //TODO("Not yet implemented")


    }
}