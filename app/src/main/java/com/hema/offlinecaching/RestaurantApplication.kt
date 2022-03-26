package com.hema.offlinecaching

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


// to make dependency processing in full app
@HiltAndroidApp
class RestaurantApplication : Application()