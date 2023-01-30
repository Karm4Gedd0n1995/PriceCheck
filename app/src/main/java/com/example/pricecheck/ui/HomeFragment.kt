package com.example.pricecheck.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.pricecheck.adapter.ProspektAdapter
import com.example.pricecheck.data.Repository
import com.example.pricecheck.databinding.FragmentMainBinding

class HomeFragment: Fragment() {

    private val viewmodel: ViewModel by viewModels()

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val prospects = Repository().loadProspects()

        binding.prospectrecycler.adapter = ProspektAdapter(requireContext(), prospects)
    }
}