package com.example.myapp.abs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class AbsStateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializedLayout()
        initObservable()
    }

    abstract fun initializedLayout()
    abstract fun initializedView()
    abstract fun initObservable()

}