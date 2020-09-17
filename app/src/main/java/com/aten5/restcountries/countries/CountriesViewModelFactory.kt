package com.aten5.restcountries.countries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aten5.domain.usecases.GetCountriesUseCase

class CountriesViewModelFactory(private val getCountriesUseCase: GetCountriesUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountriesViewModel::class.java)) {
            return CountriesViewModel(getCountriesUseCase) as T
        }
        throw IllegalArgumentException("Unsupported Class")
    }
}