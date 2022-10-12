package com.example.virginmoneychallengeandroid.repository

import com.example.virginmoneychallengeandroid.data.remote.EmployeeDetails
import com.example.virginmoneychallengeandroid.data.remote.WorlSpaceDetails
import com.example.virginmoneychallengeandroid.repository.remote.VmRemoteDataSource

class VmRepository(){

    private  val remoteDataSOurce = VmRemoteDataSource()

    suspend fun getEmployeeDetails():List<EmployeeDetails>{
       return remoteDataSOurce.getEmployeeDetailsFromRemote()
    }

    suspend fun getSpacesDetails():List<WorlSpaceDetails>{
        return remoteDataSOurce.getWorkSpacesFromRemote()
    }

}
