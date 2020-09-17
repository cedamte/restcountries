package com.aten5.restcountries.app

import android.app.Application
import com.aten5.restcountries.di.AppComponent
import com.aten5.restcountries.di.DaggerAppComponent

class CountriesApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}
