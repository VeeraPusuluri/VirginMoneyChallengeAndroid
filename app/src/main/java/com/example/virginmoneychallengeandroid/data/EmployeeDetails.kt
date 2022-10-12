package com.example.virginmoneychallengeandroid.data

import com.squareup.moshi.Json

data class EmployeeDetails(
    @Json(name = "createdAt") val createdAt:String,
    @Json(name = "firstName") val firstName:String,
    @Json(name = "avatar") val avatar:String,
    @Json(name = "lastName") val lastName:String,
    @Json(name = "email") val email:String,
    @Json(name = "jobtitle") val jobTitle:String,
    @Json(name = "favouriteColor") val favouriteColor:String,
    @Json(name = "id") val id: String,
)