package com.hema.offlinecaching.data.retrofit

import com.hema.offlinecaching.data.model.RestaurantModel
import retrofit2.http.GET

interface RestaurantApi {

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurant(): List<RestaurantModel>
}