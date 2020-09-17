package com.aten5.domain.usecases

import com.aten5.domain.entities.CountriesScreenState
import com.aten5.domain.entities.ScreenState
import com.aten5.domain.repositories.CountriesRepository
import io.reactivex.rxjava3.core.Observable

class GetCountriesUseCaseImpl(private val countriesRepository: CountriesRepository) :
    GetCountriesUseCase {
    override fun getCountries(): Observable<ScreenState> {
        return countriesRepository.getAllCountries()
            .map { list ->
                if (list.isEmpty()) {
                    ScreenState.Empty
                } else {
                    CountriesScreenState.Content(list)
                }
            }.onErrorReturn { error ->
                ScreenState.Error(errorMessage = error.message ?: "Unknown Error occurred")
            }.startWithItem(ScreenState.Loading(true))
    }
}