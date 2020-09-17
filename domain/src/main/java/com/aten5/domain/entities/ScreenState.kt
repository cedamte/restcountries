package com.aten5.domain.entities

sealed class ScreenState {
    data class Loading(val isLoading: Boolean) : ScreenState()
    data class Error(val errorMessage: String) : ScreenState()
    object Empty : ScreenState()
}

sealed class CountriesScreenState : ScreenState() {
    data class Content(val payload: List<CountriesEntity>) :
        CountriesScreenState()
}