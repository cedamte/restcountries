package com.aten5.data.repositories

import com.aten5.data.api.ApiService
import com.aten5.data.entities.AllCountriesItem
import com.aten5.domain.entities.CountriesEntity
import com.aten5.domain.repositories.CountriesRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(private val service: ApiService) :
    CountriesRepository {
    override fun getAllCountries(): Observable<List<CountriesEntity>> {
        return service.getAllCountries()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                mapToCountriesEntity(it)
            }
            .toObservable()

    }

    private fun mapToCountriesEntity(list: List<AllCountriesItem>):
            List<CountriesEntity> {
        return list.map {
            CountriesEntity(
                countryName = it.name,
                population = it.population,
                flagUrl = it.flag
            )
        }
    }
}