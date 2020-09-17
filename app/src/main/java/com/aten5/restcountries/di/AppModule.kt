package com.aten5.restcountries.di

import com.aten5.domain.usecases.GetCountriesUseCase
import com.aten5.restcountries.countries.CountriesViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun providesCountriesViewModelFactory(getCountriesUseCase: GetCountriesUseCase):
            CountriesViewModelFactory {
        return CountriesViewModelFactory(getCountriesUseCase)
    }
}