package com.example.pricecheck.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pricecheck.data.ProspectRepository
import com.example.pricecheck.data.Repository
import com.example.pricecheck.data.remote.ProspectApiobject
import kotlinx.coroutines.launch

const val TAG = "MainViewModel"

enum class ApiStatus {LOADING, ERROR, DONE}

class MainViewModel: ViewModel() {

    private val repository = ProspectRepository(ProspectApiobject)

    val prospects = repository.prospects


    fun loadProspects(){

        viewModelScope.launch {
            try {
                repository.getProspects()
            } catch (e: Exception) {
                Log.e(TAG, "failed to load Prospect: $e")

            }
        }
    }
}