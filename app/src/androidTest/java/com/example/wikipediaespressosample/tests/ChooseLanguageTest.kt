package com.example.wikipediaespressosample.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.wikipedia.main.MainActivity
import org.wikipedia.main.screenobjects.*

@LargeTest
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ChooseLanguageTest {
    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    val onboarding = OnboardingScreen()
    val mainScreen = MainScreen()
    val bottomSheet = BottomSheetScreen()
    val settings = SettingsScreen()
    val wikipediaLanguages = WikipediaLanguagesScreen()
    val addAlanguage = AddAlanguageScreen()
    val removeLanguage = RemoveLanguageScreen()
    val popUpScreen = PopUpScreen()

    val french = "Français"
    val German = "Deutsch"


    @Test
    fun addFrenchLanguage() {
        onboarding.tapButton()
        mainScreen.tapButton(mainScreen.moreId)
        bottomSheet.tapButton(bottomSheet.settingsId)
        settings.tapButtonRec(1)
        wikipediaLanguages.tapButton(wikipediaLanguages.addLanguageId, wikipediaLanguages.addLanguageText)
        addAlanguage.selectLanguage(french)
        wikipediaLanguages.checkLanguageShown(french)
        wikipediaLanguages.tapButton(wikipediaLanguages.threeDotButtonId)
        wikipediaLanguages.tapButton(wikipediaLanguages.idRemoveLanguage, wikipediaLanguages.textRemoveLanguage)
        removeLanguage.removeLanguage(french)
        removeLanguage.tapButton(removeLanguage.deleteButtonId)
        popUpScreen.tapButton(popUpScreen.okText)
        wikipediaLanguages.languageIsNotShown(french)
    }
    @Test
    fun addGermanLanguage() {
        onboarding.tapButton()
        mainScreen.tapButton(mainScreen.moreId)
        bottomSheet.tapButton(bottomSheet.settingsId)
        settings.tapButtonRec("Wikipedia languages")
        wikipediaLanguages.tapButton(wikipediaLanguages.addLanguageId, wikipediaLanguages.addLanguageText)
        addAlanguage.search()
        addAlanguage.enterText(German)
        addAlanguage.selectLanguage(German)
        wikipediaLanguages.checkLanguageShown(German)
    }
}