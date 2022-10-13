package com.example.virginmoneychallengeandroid.repository

import com.example.virginmoneychallengeandroid.data.EmployeeDetails
import com.example.virginmoneychallengeandroid.data.WorlSpaceDetails
import com.example.virginmoneychallengeandroid.repository.remote.VmRemoteDataSource

class VmRepository(){

    private  val remoteDataSOurce = VmRemoteDataSource()

    // fetches employee details from remote server
    suspend fun getEmployeeDetails():List<EmployeeDetails>{
       return remoteDataSOurce.getEmployeeDetailsFromRemote()
    }

    // fetches work space details from remote server
    suspend fun getSpacesDetails():List<WorlSpaceDetails>{
        return remoteDataSOurce.getWorkSpacesFromRemote()
    }

}
