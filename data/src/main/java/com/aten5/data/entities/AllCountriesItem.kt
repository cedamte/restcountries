package com.aten5.data.entities


import com.squareup.moshi.Json

data class AllCountriesItem(
    @Json(name = "alpha2Code")
    val alpha2Code: String,
    @Json(name = "alpha3Code")
    val alpha3Code: String,
    @Json(name = "altSpellings")
    val altSpellings: List<String>,
    @Json(name = "area")
    val area: Int,
    @Json(name = "borders")
    val borders: List<String>,
    @Json(name = "callingCodes")
    val callingCodes: List<String>,
    @Json(name = "capital")
    val capital: String,
    @Json(name = "cioc")
    val cioc: String,
    @Json(name = "currencies")
    val currencies: List<Currency>,
    @Json(name = "demonym")
    val demonym: String,
    @Json(name = "flag")
    val flag: String,
    @Json(name = "gini")
    val gini: Double,
    @Json(name = "languages")
    val languages: List<Language>,
    @Json(name = "latlng")
    val latlng: List<Int>,
    @Json(name = "name")
    val name: String,
    @Json(name = "nativeName")
    val nativeName: String,
    @Json(name = "numericCode")
    val numericCode: String,
    @Json(name = "population")
    val population: Int,
    @Json(name = "region")
    val region: String,
    @Json(name = "regionalBlocs")
    val regionalBlocs: List<RegionalBloc>,
    @Json(name = "subregion")
    val subregion: String,
    @Json(name = "timezones")
    val timezones: List<String>,
    @Json(name = "topLevelDomain")
    val topLevelDomain: List<String>,
    @Json(name = "translations")
    val translations: Translations
)