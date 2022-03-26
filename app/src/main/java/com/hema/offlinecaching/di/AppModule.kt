package com.hema.offlinecaching.di

import android.app.Application
import androidx.room.Room
import com.hema.offlinecaching.data.db.RestaurantDatabase
import com.hema.offlinecaching.data.retrofit.RestaurantApi
import com.hema.offlinecaching.utlis.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

// use hilt to can inject this class in any places we needed
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideRestaurantApi(retrofit: Retrofit): RestaurantApi =
        retrofit.create()

    @Provides
    @Singleton
    fun provideDatabase(application: Application): RestaurantDatabase =
        Room.databaseBuilder(application, RestaurantDatabase::class.java,"restaurant.db")
            .build()

}