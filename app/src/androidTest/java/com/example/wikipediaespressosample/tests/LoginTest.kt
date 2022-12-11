package com.example.wikipediaespressosample.tests

import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.main.MainActivity
import org.wikipedia.main.screenobjects.*

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginTest {
    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    val onboarding = OnboardingScreen()
    val mainScreen = MainScreen()
    val bottomSheet = BottomSheetScreen()
    val createAccount = CreateAccountScreen()
    val logIn = LogInScreen()

    @Test
    fun testLogin() {

        onboarding.tapButton()

        mainScreen.tapButton(mainScreen.moreId)

        bottomSheet.tapButton(bottomSheet.loginid)

        createAccount.isEnabledButton(createAccount.loginId)

        with(logIn){
            replaceText(usernameParent, textUserNameValid)
            replaceText(passwordParentId, textPasswordValid)
            tapButton(loginButtonId)
            checkErrorShown()
        }
    }

    @Test
    fun testEmptyField() {

        onboarding.tapButton()

        mainScreen.tapButton(mainScreen.moreId)

        bottomSheet.tapButton(bottomSheet.loginid)

        createAccount.isEnabledButton(createAccount.loginId)

        with(logIn){
            checkNotEnabled()
            replaceText(usernameParent, textUserNameValid)
            checkNotEnabled()
            deleteText(usernameParent)
            replaceText(passwordParentId, textPasswordValid)
            checkNotEnabled()
        }
    }
}