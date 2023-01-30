package com.example.pricecheck.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pricecheck.adapter.DetailAdapter
import com.example.pricecheck.databinding.FragmentProspectBinding

class ProspectFragment: Fragment() {

    private val viewModel: MainViewModel by viewModels()


    private lateinit var binding: FragmentProspectBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProspectBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val detailAdapter = DetailAdapter()
            binding.detailrecycler.adapter = detailAdapter
       // detailAdapter.submitlist(viewModel.prospects.value)



    }
}