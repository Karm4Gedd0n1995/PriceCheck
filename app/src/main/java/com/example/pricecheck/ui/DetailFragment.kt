package com.example.pricecheck.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.pricecheck.databinding.ListItemBinding

class ItemFragment: Fragment() {

    private val viewModel: ViewModel by viewModels()

    private lateinit var binding: ListItemBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListItemBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



       // binding.prospectview.setOnClickListener {
         //   findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToProspectFragment())
       // }


    }
}