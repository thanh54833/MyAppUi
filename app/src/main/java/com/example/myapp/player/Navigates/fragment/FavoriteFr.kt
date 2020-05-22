package com.example.myapp.player.Navigates.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapp.R
import com.example.myapp.abs.AbsFragment
import com.example.myapp.databinding.MainFavriterFrBinding

class FavoriteFr : AbsFragment() {
    private lateinit var binding: MainFavriterFrBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_favriter_fr, container, false)
        return binding.root
    }

    override fun initializedView() {
        //TODO("Not yet implemented")
    }

    override fun initObservable() {
        //TODO("Not yet implemented")
    }


}