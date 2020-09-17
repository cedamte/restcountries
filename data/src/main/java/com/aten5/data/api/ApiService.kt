package com.aten5.data.api

import com.aten5.data.BuildConfig
import com.aten5.data.entities.AllCountriesItem
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {
    @GET(BuildConfig.ALL_ENDPOINT)
    fun getAllCountries(): Single<List<AllCountriesItem>>
}