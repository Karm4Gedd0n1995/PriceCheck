package com.example.pricecheck.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
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
        viewModel.loadProspects()
        viewModel.prospects.observe(viewLifecycleOwner){
            detailAdapter.submitlist(it)
            Log.d("prospectfragment","oberserver wurde getriggert $it")
        }

        binding.prospectbutton2.setOnClickListener {
            findNavController().navigate(ProspectFragmentDirections.actionProspectFragmentToHomeFragment())

           binding.favouritebutton2.setOnClickListener {
                findNavController().navigate(ProspectFragmentDirections.actionProspectFragmentToFavouriteFragment4())
            }

        }}}






