package com.example.pricecheck.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.pricecheck.databinding.FragmentFavouriteBinding
import com.example.pricecheck.databinding.FragmentProspectBinding

class FavouriteFragment:Fragment() {

    private lateinit var binding: FragmentFavouriteBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.prospectbutton3.setOnClickListener {
            findNavController().navigate(FavouriteFragmentDirections.actionFavouriteFragmentToHomeFragment())
        }


    }

}