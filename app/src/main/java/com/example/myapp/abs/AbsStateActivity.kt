package com.example.myapp.abs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.player.PlayerAct

abstract class AbsStateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializedLayout()
        initObservable()
    }

    abstract fun initializedLayout()
    abstract fun initObservable()

}