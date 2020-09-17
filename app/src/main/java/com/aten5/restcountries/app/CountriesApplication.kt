package com.aten5.restcountries.app

import android.app.Application
import com.aten5.restcountries.BuildConfig
import com.aten5.restcountries.di.AppComponent
import com.aten5.restcountries.di.DaggerAppComponent
import timber.log.Timber

class CountriesApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        appComponent.inject(this)
    }
}
