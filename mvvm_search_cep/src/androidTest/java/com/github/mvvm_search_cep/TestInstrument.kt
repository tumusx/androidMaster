package com.github.mvvm_search_cep

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import com.github.mvvm_search_cep.view.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class TestInstrument {

private lateinit var numberCep : String

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun initValid(){
        numberCep = "74785390"
    }

    @Test
    fun changeTest() {
        onView(withId(R.id.editTextTextPersonName)).perform(typeText(numberCep), closeSoftKeyboard())
        onView(withId(R.id.btnSearchCEP)).perform(click())


        onView(withId(R.id.editTextTextPersonName))
            .check(matches(withText(numberCep)))
    }
}