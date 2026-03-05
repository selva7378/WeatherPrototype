package com.example.wetherprototype.data.remote.dto.geocode

import kotlinx.serialization.Serializable

data class Result(
    val admin1: String? = null,
    val admin1_id: Int? = null,
    val admin2: String? = null,
    val admin2_id: Int? = null,
    val admin3: String? = null,
    val admin3_id: Int? = null,
    val admin4: String? = null,
    val admin4_id: Int? = null,
    val country: String,
    val country_code: String,
    val country_id: Int,
    val elevation: Double? = null,
    val feature_code: String? = null,
    val id: Int,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val population: Int? = null,
    val postcodes: List<String>? = null,
    val timezone: String
)