package com.example.wikipediaespressosample.screenobject

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.allOf
import org.wikipedia.R

class OnboardingScreen {
    fun tapButton(){
        onView(
            withId(R.id.fragment_onboarding_skip_button)
        ).perform(click())}

    var list = listOf(R.id.fragment_onboarding_forward_button, R.id.fragment_onboarding_forward_button, R.id.fragment_onboarding_forward_button )

    fun tapButton (name: List<Int>) {

        for (i in name) {
            onView(
                allOf(
                    withId(i),

                    isDisplayed()
                )
            ).perform(click())
        }
    }
}