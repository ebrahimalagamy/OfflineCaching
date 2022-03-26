package com.hema.offlinecaching.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hema.offlinecaching.data.model.RestaurantModel
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {

    @Query("select * from restaurants")
    fun getRestaurants():Flow<List<RestaurantModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(restaurants: List<RestaurantModel>)

    @Query("DELETE FROM restaurants")
    suspend fun delete()

}