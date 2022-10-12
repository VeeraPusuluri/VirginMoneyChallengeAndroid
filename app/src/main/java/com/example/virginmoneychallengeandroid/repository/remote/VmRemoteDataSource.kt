package com.example.virginmoneychallengeandroid.repository.remote

import android.util.Log
import com.example.virginmoneychallengeandroid.data.remote.EmployeeDetails
import com.example.virginmoneychallengeandroid.data.remote.VmApi
import com.example.virginmoneychallengeandroid.data.remote.WorlSpaceDetails

private const val TAG = "VmRemoteDataSource"

class VmRemoteDataSource {

    private val retrofitInstance = VmApi.retrofitInstance

    suspend fun getEmployeeDetailsFromRemote(): List<EmployeeDetails> {
        return try {
            val data = retrofitInstance.getEmployeeDetails()
            data
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            Log.d(TAG, "error getting value from server msg = ${e.message}")
            emptyList<EmployeeDetails>()
        }
    }

    suspend fun getWorkSpacesFromRemote(): List<WorlSpaceDetails> {
        return try {
            val data = retrofitInstance.getWorkSpacesDetails()
            data
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            Log.d(TAG, " error getting rooms details from server msg = ${e.message}")
            emptyList<WorlSpaceDetails>()
        }
    }
}