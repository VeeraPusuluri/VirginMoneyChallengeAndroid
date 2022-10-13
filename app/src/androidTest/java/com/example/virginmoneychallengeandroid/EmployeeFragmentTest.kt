package com.example.virginmoneychallengeandroid

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EmployeeFragmentTest {

    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkEmployeeDetails_fetched_displayedOrNot() {
        Thread.sleep(2000)
        onView(withId(R.id.recyclerview_employees)).perform(
            RecyclerViewActions
                .scrollToPosition<RecyclerView.ViewHolder>(9)
        )
        onView(withText("9")).check(matches(isDisplayed()))
    }

    @Test
    fun performClick_onEmployeeSlidingPane_isDisplayedOrNot() {
        Thread.sleep(2000)
        onView(withId(R.id.recyclerview_employees)).perform(
            RecyclerViewActions
                .scrollToPosition<RecyclerView.ViewHolder>(9)
        )
        onView((withText("9"))).perform(click())
        onView(withText("9")).check(matches(isDisplayed()))
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.pressBack()
        onView(withText("9")).check(matches(isDisplayed()))
    }

}