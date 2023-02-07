package com.example.pricecheck.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pricecheck.data.model.Prospect

@Dao
interface FavouriteDatabaseDao {

    @Query("SELECT * FROM Prospect")
    fun getAll(): LiveData<List<Prospect>>

    @Query("SELECT * FROM Prospect WHERE liked = 1")
    fun getFavourites(): LiveData<List<Prospect>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(daoProspect: List<Prospect>)

    @Update
    suspend fun update(daoProspect: Prospect)

    @Delete
    suspend fun delete(daoProspect: Prospect)
}