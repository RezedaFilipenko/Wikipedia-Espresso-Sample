package com.example.wikipediaespressosample.screenobject

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import org.wikipedia.R

class BottomSheetScreen {
    val loginid = R.id.main_drawer_account_container
    val settingsId = R.id.main_drawer_settings_container
    val donateId = R.id.main_drawer_donate_container

    fun tapButton(id: Int){
        onView(
            withId(id)
        ).perform(click())}
}