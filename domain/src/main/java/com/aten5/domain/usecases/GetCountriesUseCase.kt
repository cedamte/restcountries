package com.aten5.domain.usecases

import com.aten5.domain.entities.ScreenState
import io.reactivex.rxjava3.core.Observable

interface GetCountriesUseCase {
    fun getCountries(): Observable<ScreenState>
}