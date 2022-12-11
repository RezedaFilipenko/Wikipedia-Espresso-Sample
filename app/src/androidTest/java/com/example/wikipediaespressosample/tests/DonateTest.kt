package com.example.wikipediaespressosample.tests

import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.main.MainActivity
import org.wikipedia.main.screenobjects.*

@LargeTest
@RunWith(AndroidJUnit4::class)
class DonateTest {
    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    val onboarding = OnboardingScreen()
    val mainScreen = MainScreen()
    val bottomSheet = BottomSheetScreen()
    val donateIntent = DonateIntent()

    @Test
    fun donateTest(){
        Intents.init()
        onboarding.tapButton()
        mainScreen.tapButton(mainScreen.moreId)
        bottomSheet.tapButton(bottomSheet.donateId)
        donateIntent.checkIntent()
        Intents.release()
    }
}