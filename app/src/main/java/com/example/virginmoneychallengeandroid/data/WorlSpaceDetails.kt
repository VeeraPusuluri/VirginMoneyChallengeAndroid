package com.example.virginmoneychallengeandroid.data

import com.squareup.moshi.Json

data class WorlSpaceDetails(
    @Json(name = "createdAt") val createdAt: String,
    @Json(name = "isOccupied") val isOccupied: Boolean,
    @Json(name = "maxOccupancy") val maxOccupancy: Int,
    @Json(name = "id") val id: String
)