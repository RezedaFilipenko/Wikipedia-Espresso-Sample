package com.example.wikipediaespressosample.screenobject

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.R

class MainScreen {
    val moreId = R.id.nav_more_container
    val editId = R.id.nav_tab_edits
    val searchId = R.id.nav_tab_search
    val savedId = R.id.nav_tab_reading_lists
    val exploreId = R.id.nav_tab_explore

    fun tapButton(id: Int){
        onView(
            withId(id)
        ).perform(click())}
}