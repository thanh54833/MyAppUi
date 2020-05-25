package com.example.myapp.player.Navigates.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.myapp.R
import com.example.myapp.abs.AbsFragment
import com.example.myapp.databinding.MainSettingFrBinding

class SettingFr : AbsFragment() {
    lateinit var binding: MainSettingFrBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_setting_fr, container, false)
        return binding.root
    }

    override fun initializedView() {


    }

    override fun initObservable() {


    }
}