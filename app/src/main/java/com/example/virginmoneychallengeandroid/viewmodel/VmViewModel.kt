package com.example.virginmoneychallengeandroid.viewmodel

import androidx.lifecycle.*
import com.example.virginmoneychallengeandroid.data.EmployeeDetails
import com.example.virginmoneychallengeandroid.data.WorlSpaceDetails
import com.example.virginmoneychallengeandroid.repository.VmRepository
import kotlinx.coroutines.launch

private  const val TAG = "VmViewModel"
class VmViewModel : ViewModel() {


    private var _employeeDetails = MutableLiveData<List<EmployeeDetails>>()
    val employeeDetails: LiveData<List<EmployeeDetails>> get() = _employeeDetails
    private var _workSpaces = MutableLiveData<List<WorlSpaceDetails>>()
    val workSpaces: LiveData<List<WorlSpaceDetails>> get() = _workSpaces
    private val VmRepositoryInstance = VmRepository()
    private val _currentEmployee = MutableLiveData<EmployeeDetails>()
    val currentEmployee:LiveData<EmployeeDetails> get() = _currentEmployee


    // to fetch employee details from repository
    fun getEmployeeDetails() {
        viewModelScope.launch {
            _employeeDetails.value = VmRepositoryInstance.getEmployeeDetails()
        }
    }

    // to fetch work space details from repository
    fun getWorkSpacesDetails() {
        viewModelScope.launch {
            _workSpaces.value = VmRepositoryInstance.getSpacesDetails()
        }
    }

    //sets data for current employee to display in sliding pane layout
    fun setCurrentEmployeeData(data: EmployeeDetails) {
        _currentEmployee.value = data
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