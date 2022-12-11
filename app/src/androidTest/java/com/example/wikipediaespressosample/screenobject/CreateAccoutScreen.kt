package com.example.wikipediaespressosample.screenobject

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.allOf
import org.wikipedia.R

class CreateAccountScreen {
    val usernameParent = R.id.create_account_username
    val passwordParentId = R.id.create_account_password_input
    val repeatPasswordParentId = R.id.create_account_password_repeat
    val nextId = R.id.create_account_submit_button
    val loginId = R.id.create_account_login_button
    val textUserNameValid = "Rezeda12345678"
    val textPasswordValid = "Rezeda12345"
    val textPasswordInvalid = "qwertyu"
    val incorrectPasswordError = "The password must be at least 8 characters"


    fun buttonNotEnabled(){
        onView(
            withId(R.id.create_account_submit_button)
        ).check(matches(isNotEnabled())) }


    fun replaceText(id: Int, text: String){
        onView(
            allOf(
                isDescendantOfA(withId(id)),
                hasSibling(withChild( withId(R.id.text_input_start_icon))),
                hasSibling(withChild(withId(R.id.text_input_error_icon)))
            )
        ).perform(replaceText(text), closeSoftKeyboard())}


    fun isEnabledButton(id: Int){
        onView(
            withId(id)
        ).check(matches(isEnabled())).perform(click())}

    fun checkError(id: Int, text: String){
        onView(
            allOf(
                isDescendantOfA(withId(id)),
                withId(R.id.textinput_error)
            )
        ).check(
            matches(withText(text))
        )
    }
}