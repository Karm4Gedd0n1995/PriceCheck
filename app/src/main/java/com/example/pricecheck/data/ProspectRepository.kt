package com.example.pricecheck.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pricecheck.data.model.Prospect
import com.example.pricecheck.data.remote.ProspectApi

class ProspectRepository(private val api: ProspectApi) {

    private val _prospects = MutableLiveData<List<ProspectApi>>()
    val prospects: LiveData<List<ProspectApi>>
    get() = _prospects


    suspend fun getProspects(){
        _prospects.value = api.retrofitService.getProspects()
    }


}