package com.aten5.restcountries.countries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aten5.domain.entities.CountriesEntity
import com.aten5.domain.entities.CountriesScreenState
import com.aten5.domain.entities.ScreenState
import com.aten5.domain.usecases.GetCountriesUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class CountriesViewModel(
    private val getCountriesUseCase: GetCountriesUseCase
) : ViewModel() {

    init {
        getCountriesData()
    }

    private val _errorObservable: MutableLiveData<String> = MutableLiveData()
    val errorObservable: LiveData<String>
        get() = _errorObservable


    private val _loadingObservable: MutableLiveData<Boolean> = MutableLiveData()
    val loadingObservable: LiveData<Boolean>
        get() = _loadingObservable

    private val _countriesObservables: MutableLiveData<List<CountriesEntity>> =
        MutableLiveData()

    val countriesObservables: LiveData<List<CountriesEntity>>
        get() = _countriesObservables


    private fun getCountriesData() {
        getCountriesUseCase.getCountries()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { processData(it) }
    }

    private fun processData(screenState: ScreenState) {
        when (screenState) {
            is CountriesScreenState.Content -> {
                _countriesObservables.value = screenState.payload
                removeLoading()
            }
            is ScreenState.Error -> {
                _errorObservable.value = screenState.errorMessage
                removeLoading()
            }
            is ScreenState.Loading -> {
                if (screenState.isLoading) {
                    showLoading()
                } else {
                    removeLoading()
                }
            }
        }
    }

    private fun removeLoading() {
        _loadingObservable.value = false
    }

    private fun showLoading() {
        _loadingObservable.value = true
    }
}