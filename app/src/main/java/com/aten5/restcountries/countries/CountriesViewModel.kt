package com.aten5.restcountries.countries

import android.view.View
import android.widget.Button
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

    enum class SortType {
        NameASC,
        NameDESC,
        PopulationASC,
        PopulationDESC,
    }

    private var sortType: SortType = SortType.NameDESC

    private var sortByPopulation: Boolean = true
    private var sortByName: Boolean = true

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
                when (sortType) {
                    SortType.NameASC -> {
                        _countriesObservables.value =
                            screenState.payload.sortedByDescending {
                                it.countryName
                            }
                        removeLoading()
                    }
                    SortType.NameDESC -> {
                        _countriesObservables.value =
                            screenState.payload.sortedBy {
                                it.countryName
                            }
                        removeLoading()
                    }
                    SortType.PopulationASC -> {
                        _countriesObservables.value =
                            screenState.payload.sortedByDescending {
                                it.population
                            }
                        removeLoading()
                    }
                    SortType.PopulationDESC -> {
                        _countriesObservables.value =
                            screenState.payload.sortedBy {
                                it.population
                            }
                        removeLoading()
                    }
                }
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

    fun sortList(view: View) {
        when ((view as Button).text) {
            "Name" -> {
                when {
                    sortByName -> {
                        sortType = SortType.NameASC
                        sortByName = false
                    }
                    !sortByName -> {
                        sortType = SortType.NameDESC
                        sortByName = true
                    }
                }

                getCountriesData()
            }
            "Population" -> {
                when {
                    sortByPopulation -> {
                        sortType = SortType.PopulationASC
                        sortByPopulation = false
                    }
                    !sortByPopulation -> {
                        sortType = SortType.PopulationDESC
                        sortByPopulation = true
                    }
                }
                getCountriesData()
            }
        }
    }
}