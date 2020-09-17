package com.aten5.domain.repositories

import com.aten5.domain.entities.CountriesEntity
import io.reactivex.rxjava3.core.Observable

interface CountriesRepository {
    fun getAllCountries(): Observable<List<CountriesEntity>>
}