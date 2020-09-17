package com.aten5.restcountries.countries

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.aten5.data.api.ApiService
import com.aten5.data.repositories.CountriesRepositoryImpl
import com.aten5.domain.entities.CountriesEntity
import com.aten5.domain.entities.CountriesScreenState
import com.aten5.domain.entities.ScreenState
import com.aten5.domain.repositories.CountriesRepository
import com.aten5.domain.usecases.GetCountriesUseCase
import com.aten5.domain.usecases.GetCountriesUseCaseImpl
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.reactivex.rxjava3.core.Observable
import junit.framework.Assert.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner

@RunWith(BlockJUnit4ClassRunner::class)
class CountriesViewModelTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @MockK
    lateinit var getCountriesUseCase: GetCountriesUseCase

    private lateinit var countriesViewModel: CountriesViewModel


    @Before
    fun before() {
        MockKAnnotations.init(this)
        countriesViewModel = CountriesViewModel(getCountriesUseCase)
    }

    @Test
    fun `list is retrieved`() {
        // Given
        val countries = listOf(
            CountriesEntity(
                "England",
                60,
                "dummyFlag"
            ),

            CountriesEntity(
                "Scotland",
                10,
                "dummyFlag"
            ),

            CountriesEntity(
                "Wales",
                20,
                "dummyFlag"
            ),

            )
        val screenState = CountriesScreenState.Content(countries)

        every { getCountriesUseCase.getCountries() } returns (Observable.just(screenState))

        // When
        countriesViewModel.getCountriesData()

        // Then
        assertEquals(countries, countriesViewModel.countriesObservables.value)
    }

    @Test
    fun `error message is retrieved`() {
        // Given
        val screenState = ScreenState.Error("An error occurred")
        every { getCountriesUseCase.getCountries() } returns (Observable.just(screenState))

        // When
        countriesViewModel.getCountriesData()

        // Then
        assertEquals(screenState.errorMessage, countriesViewModel.errorObservable.value)
    }
}