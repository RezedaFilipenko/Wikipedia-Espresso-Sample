package com.example.wikipediaespressosample.screenobject

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.allOf
import org.wikipedia.R

class WikipediaLanguagesScreen {

    val threeDotButtonId = R.id.menu_delete_selected
    val addLanguageId = R.id.wiki_language_title
    val addLanguageText = "Add language"
    val textRemoveLanguage = "Remove language"
    val idRemoveLanguage = R.id.title

    fun tapButton(id: Int, text: String){
        onView(
            allOf(
                withId(id),
                withText(text))
        ).perform(click())
    }

    fun checkLanguageShown(text: String){
        onView(
            allOf(
                withId(R.id.wiki_language_title),
                withText(text),
                isDescendantOfA(withId(R.id.wikipedia_languages_recycler))
            )
        ).check(matches(isDisplayed()))
    }
    fun tapButton(id: Int){
        onView((
                withId(id)
                )
        ).perform(click())
    }
    fun languageIsNotShown(text: String){
        onView(
            allOf(
                withText(text),
                isDescendantOfA(withId(R.id.wikipedia_languages_recycler)))
        ).check(doesNotExist())
    }
}