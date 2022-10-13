package com.example.virginmoneychallengeandroid.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.virginmoneychallengeandroid.data.EmployeeDetails
import com.example.virginmoneychallengeandroid.getOrAwaitValue
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class VmViewModelTest{

    private var viewModel:VmViewModel = VmViewModel()

    @get:Rule
    val instant = InstantTaskExecutorRule()


    @Test
    fun TestLiveData_CurrentEmployee(){

        val currentEmployee = EmployeeDetails("13/10/2022", "veera","","pusulur","veeravenkata.pusuluri@gmail.com",
        "android developer","color","1")
        viewModel.setCurrentEmployeeData(currentEmployee)
        val livedata = viewModel.currentEmployee.getOrAwaitValue()

        MatcherAssert.assertThat(livedata, Matchers.`is`(currentEmployee))
    }

    @Test
    fun employeeDetails_fromRepository_isNullOrNot()= runBlocking {
        viewModel.getEmployeeDetails()
        val employeeDetails = viewModel.employeeDetails
        MatcherAssert.assertThat(employeeDetails, Matchers.`is` (notNullValue()))
    }

    @Test
    fun workSpacesDetails_fromRepository_isNullOrNot() = runBlocking{
        viewModel.getWorkSpacesDetails()
        val workSpaceDetails = viewModel.workSpaces
        MatcherAssert.assertThat(workSpaceDetails, Matchers.`is` (notNullValue()))
    }

}












