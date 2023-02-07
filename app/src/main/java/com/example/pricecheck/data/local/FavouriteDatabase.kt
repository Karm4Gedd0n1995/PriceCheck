package com.example.pricecheck.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pricecheck.data.model.Prospect


@Database(entities = [Prospect::class], version = 1)
abstract class FavouriteDatabase : RoomDatabase() {

    abstract val favouriteDatabaseDao: FavouriteDatabaseDao
}

private lateinit var INSTANCE: FavouriteDatabase

fun getDatabase(context: Context): FavouriteDatabase{
    synchronized(FavouriteDatabase::class.java){
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                FavouriteDatabase::class.java,
                "prospect_database"
            )
                .build()
        }
    }
    return INSTANCE
}



