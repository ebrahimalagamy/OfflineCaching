package com.hema.offlinecaching.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hema.offlinecaching.data.model.RestaurantModel
import com.hema.offlinecaching.data.retrofit.RestaurantApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
we inject hilt in viewModel because the view model not should response of finding retrofit instead
we should passed from out side and hilt will do for us
 */
@HiltViewModel
class RestaurantViewModel @Inject constructor(api: RestaurantApi) : ViewModel() {
    /**
   - we make restaurantMLD private because we don't expose MLD to the activity because
     the activity should be able to change what is in the MLD..
   - and assign restaurantMLD to restaurantLD because the LiveData change changed only viewModel
     can able to change it
     */
    private val restaurantMLD = MutableLiveData<List<RestaurantModel>>()
    val restaurantLD : LiveData<List<RestaurantModel>> =restaurantMLD

    //this will execute when viewModel instantiate
    init {
        viewModelScope.launch {
            val restaurants = api.getRestaurant()
            delay(2000)
            restaurantMLD.value = restaurants
        }

    }
}