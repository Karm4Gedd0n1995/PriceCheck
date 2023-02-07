package com.example.pricecheck.data.local

import com.example.pricecheck.data.model.Prospect

class DaoRepository(private val database: FavouriteDatabase) {

    val prospects = database.favouriteDatabaseDao.getFavourites()

    suspend fun insertProspect(daoProspect: List<Prospect>) {
        database.favouriteDatabaseDao.insert(daoProspect)
    }

    suspend fun updateProspect(daoProspect: Prospect){
        database.favouriteDatabaseDao.update(daoProspect)
    }

    suspend fun deleteProspect(daoProspect: Prospect) {
        database.favouriteDatabaseDao.delete(daoProspect)
    }


}