package com.example.myapp.abs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class AbsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initializedView()
        initObservable()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    abstract fun initializedView()
    abstract fun initObservable()
}