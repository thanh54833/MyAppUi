package com.example.myapp.main


import com.example.commons.sharepreference.intPreference
import com.example.myapp.abs.AbsStateActivity
import com.example.myapp.player.PlayerAct

class MainAct : AbsStateActivity() {

    override fun initializedLayout() {
        //startActivity(PlayerAct.getIntent(this))
        startActivity(PlayerAct.getIntent(this))

    }

    override fun initializedView() {

    }

    override fun initObservable() {


    }
}