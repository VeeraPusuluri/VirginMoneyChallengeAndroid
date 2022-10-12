package com.example.virginmoneychallengeandroid.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://61e947967bc0550017bc61bf.mockapi.io/api/v1/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface VmApiService {

    @GET("people")
    suspend fun getEmployeeDetails(): List<EmployeeDetails>

    @GET("rooms")
    suspend fun getWorkSpacesDetails(): List<WorlSpaceDetails>
}

object VmApi{
  val retrofitInstance: VmApiService by lazy { retrofit.create(VmApiService::class.java) }
}