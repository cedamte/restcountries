package com.aten5.data.entities


import com.squareup.moshi.Json

data class Translations(
    @Json(name = "br")
    val br: String,
    @Json(name = "de")
    val de: String,
    @Json(name = "es")
    val es: String,
    @Json(name = "fa")
    val fa: String,
    @Json(name = "fr")
    val fr: String,
    @Json(name = "hr")
    val hr: String,
    @Json(name = "it")
    val `it`: String,
    @Json(name = "ja")
    val ja: String,
    @Json(name = "nl")
    val nl: String,
    @Json(name = "pt")
    val pt: String
)