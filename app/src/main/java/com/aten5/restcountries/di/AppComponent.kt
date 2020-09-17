package com.aten5.restcountries.di

import com.aten5.restcountries.app.CountriesApplication
import com.aten5.restcountries.countries.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [])
interface AppComponent {
    fun inject(application: CountriesApplication)
    fun inject(mainActivity: MainActivity)
}