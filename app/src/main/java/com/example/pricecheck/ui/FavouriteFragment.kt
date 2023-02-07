package com.example.pricecheck.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.pricecheck.adapter.FavouriteAdapter
import com.example.pricecheck.data.model.Prospect
import com.example.pricecheck.databinding.FragmentFavouriteBinding

class FavouriteFragment(


):Fragment()
 {
     private val viewModel: MainViewModel by activityViewModels()

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

        var update = {daoProspect: Prospect ->
            viewModel.updateprospect(daoProspect)}

       var adapter = FavouriteAdapter(update)
        binding.favouriterecycler.adapter = adapter

        viewModel.daoprospects.observe(viewLifecycleOwner){
            adapter.submitlist(it)
        }

        binding.prospectbutton3.setOnClickListener {
            findNavController().navigate(FavouriteFragmentDirections.actionFavouriteFragmentToHomeFragment())
        }


    }

}