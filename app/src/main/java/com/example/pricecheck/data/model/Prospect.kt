package com.example.pricecheck.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Prospect (

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val name: String,
    val imageid: Int,
    var liked :Boolean = false
)