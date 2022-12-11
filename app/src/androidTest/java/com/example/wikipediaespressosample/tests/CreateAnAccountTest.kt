package com.example.wikipediaespressosample.tests

import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.main.MainActivity
import org.wikipedia.main.screenobjects.BottomSheetScreen
import org.wikipedia.main.screenobjects.CreateAccountScreen
import org.wikipedia.main.screenobjects.MainScreen
import org.wikipedia.main.screenobjects.OnboardingScreen

@LargeTest
@RunWith(AndroidJUnit4::class)
class CreateAnAccountTest{
    @Rule
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    val onboarding = OnboardingScreen()
    val mainScreen = MainScreen()
    val bottomSheet = BottomSheetScreen()
    val createAccount = CreateAccountScreen()


    @Test
    fun validUserNameAndPasswordMatch() {

        onboarding.tapButton()

        mainScreen.tapButton(mainScreen.moreId)

        bottomSheet.tapButton(bottomSheet.loginid)

        with(createAccount){
            buttonNotEnabled()
            replaceText(usernameParent, textUserNameValid)
            replaceText(passwordParentId, textPasswordValid)
            replaceText(repeatPasswordParentId, textPasswordValid)
            isEnabledButton(nextId)
        }
    }

    @Test
    fun invalidPassword() {
        onboarding.tapButton()

        mainScreen.tapButton(mainScreen.moreId)

        bottomSheet.tapButton(bottomSheet.loginid)

        with(createAccount){
            buttonNotEnabled()
            replaceText(usernameParent, textUserNameValid)
            replaceText(passwordParentId, textPasswordInvalid)
            replaceText(repeatPasswordParentId, textPasswordInvalid)
            isEnabledButton(nextId)
            checkError(passwordParentId, incorrectPasswordError)
        }
    }
}