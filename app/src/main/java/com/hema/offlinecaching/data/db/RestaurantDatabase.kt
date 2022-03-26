package com.hema.offlinecaching.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hema.offlinecaching.data.dao.RestaurantDao
import com.hema.offlinecaching.data.model.RestaurantModel

@Database(entities = [RestaurantModel::class], version = 1)
abstract class RestaurantDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao

}