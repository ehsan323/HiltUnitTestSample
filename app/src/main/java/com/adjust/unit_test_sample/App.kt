package com.adjust.unit_test_sample

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

//    override  fun applicationInjector(): AndroidInjector<out DaggerApplication> {
//        return DaggerAppComponent.builder().create(this)
//    }


}
