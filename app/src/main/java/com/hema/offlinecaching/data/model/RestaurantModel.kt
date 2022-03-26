package com.hema.offlinecaching.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "restaurants")
data class RestaurantModel(
    @PrimaryKey
    val name: String,
    val type: String,
    val logo: String,
    val address: String
)