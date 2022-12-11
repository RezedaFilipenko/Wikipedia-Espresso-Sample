package com.example.wikipediaespressosample.screenobject

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import org.wikipedia.R

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId

class PopUpScreen {

    val okText = "OK"
    val cancelText = "Cancel"

    fun tapButton(text: String){
        onView(
            withText(text)
        ).perform(click())
    }
}