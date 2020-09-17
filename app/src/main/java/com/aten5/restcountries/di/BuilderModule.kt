package com.aten5.restcountries.di

import com.aten5.data.repositories.CountriesRepositoryImpl
import com.aten5.domain.repositories.CountriesRepository
import com.aten5.domain.usecases.GetCountriesUseCase
import com.aten5.domain.usecases.GetCountriesUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class BuilderModule {
    @Binds
    abstract fun bindGetCountriesUseCase(getCountriesUseCaseImpl: GetCountriesUseCaseImpl):
            GetCountriesUseCase

    @Binds
    abstract fun bindCountriesRepository(countriesRepositoryImpl: CountriesRepositoryImpl):
            CountriesRepository
}