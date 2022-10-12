package com.example.virginmoneychallengeandroid.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.virginmoneychallengeandroid.data.remote.EmployeeDetails
import com.example.virginmoneychallengeandroid.data.remote.WorlSpaceDetails
import com.example.virginmoneychallengeandroid.repository.VmRepository
import kotlinx.coroutines.launch

private  const val TAG = "VmViewModel"
class VmViewModel : ViewModel() {


    private var _employeeDetails = MutableLiveData<List<EmployeeDetails>>()
    val employeeDetails: LiveData<List<EmployeeDetails>> get() = _employeeDetails
    private var _workSpaces = MutableLiveData<List<WorlSpaceDetails>>()
    val workSpaces: LiveData<List<WorlSpaceDetails>> get() = _workSpaces
    private val VmRepositoryInstance = VmRepository()


    fun getEmployeeDetails() {
        viewModelScope.launch {
            _employeeDetails.value = VmRepositoryInstance.getEmployeeDetails()
        }
    }

    fun getWorkSpacesDetails() {
        viewModelScope.launch {
            _workSpaces.value = VmRepositoryInstance.getSpacesDetails()
        }
    }

    class VmViewmodelFactory() : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(VmViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return VmViewModel() as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}