package com.example.pricecheck.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pricecheck.data.ProspectRepository
import com.example.pricecheck.data.local.DaoRepository
import com.example.pricecheck.data.local.FavouriteDatabase
import com.example.pricecheck.data.local.FavouriteDatabaseDao
import com.example.pricecheck.data.local.getDatabase
import com.example.pricecheck.data.model.Prospect
import com.example.pricecheck.data.remote.ProspectApiobject
import kotlinx.coroutines.launch

const val TAG = "MainViewModel"

enum class ApiStatus {LOADING, ERROR, DONE}

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val daoRepository = DaoRepository(database)
    val daoprospects = daoRepository.prospects

    fun insertprospect(daoProspect: List<Prospect>){

        viewModelScope.launch {
            try {
                daoRepository.insertProspect(daoProspect)
            } catch (e: Exception){
                Log.e("MainViewModel","failed inserting prospect $e")
            }
        }



    }

    fun updateprospect(daoProspect: Prospect){
        viewModelScope.launch {
            try {
                daoRepository.updateProspect(daoProspect)
            }catch (e:Exception){
                Log.e("MainViewModel","failed to update Favourites")
            }
        }
    }

    fun deleteprospect(daoProspect: Prospect){

        viewModelScope.launch {
            try {
                daoRepository.deleteProspect(daoProspect)
            } catch (e: Exception){
                Log.e("MainViewModel","failed deleting prospect $e")
            }
        }

    }





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