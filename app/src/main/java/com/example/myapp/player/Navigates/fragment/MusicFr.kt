package com.example.myapp.player.Navigates.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.myapp.R
import com.example.myapp.abs.AbsFragment
import com.example.myapp.databinding.MainMusicFrBinding

class MusicFr : AbsFragment() {
    lateinit var binding: MainMusicFrBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_music_fr, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navigateController = Navigation.findNavController(binding.root)
        navigateController.navigate(R.id.action_musicFr_to_favoriteFr)

    }

    override fun initializedView() {

    }

    override fun initObservable() {


    }
}