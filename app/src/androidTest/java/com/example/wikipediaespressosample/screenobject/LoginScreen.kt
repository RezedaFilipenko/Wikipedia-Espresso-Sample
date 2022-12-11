package com.example.wikipediaespressosample.screenobject

import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matchers

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.R
import org.wikipedia.main.screenobjects.*

class LogInScreen {
    val usernameParent = R.id.login_username_text
    val passwordParentId = R.id.login_password_input
    val textUserNameValid = "Username"
    val textPasswordValid = "password1"
    val loginButtonId = R.id.login_button

    fun replaceText(id: Int, text: String){
        onView(
            allOf(
                isDescendantOfA(withId(id)),
                hasSibling(withChild(withId(R.id.text_input_start_icon))),
                hasSibling(withChild(withId(R.id.textinput_suffix_text)))
            )
        ).perform(replaceText(text))
    }
    fun tapButton(id: Int){
        onView(
            withId(id)
        ).check(matches(isEnabled())).perform(click())
    }
    fun checkErrorShown(){
        onView(
            withId(R.id.snackbar_text)
        ).check(matches(withText(startsWith("Incorrect username or password entered."))))
    }
    fun checkNotEnabled(){
        onView(
            withId(R.id.login_button)
        ).check(matches(isNotEnabled()))
    }
    fun deleteText(id: Int){
        onView(
            allOf(
                isDescendantOfA(withId(id)),
                hasSibling(withChild(withId(R.id.text_input_start_icon))),
                hasSibling(withChild(withId(R.id.textinput_suffix_text)))
            )
        ).perform(clearText())
    }
}