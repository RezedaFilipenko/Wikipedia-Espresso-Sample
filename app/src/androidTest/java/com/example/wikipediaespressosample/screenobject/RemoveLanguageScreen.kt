package com.example.wikipediaespressosample.screenobject

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import org.wikipedia.R

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId


class RemoveLanguageScreen {

    val deleteButtonId = R.id.menu_delete_selected

    fun removeLanguage(text: String){
        onView(
            withId(R.id.wikipedia_languages_recycler)
        ).perform(RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(hasDescendant(withText(text)), click()))
    }

    fun tapButton(id: Int){
        onView(
            withId(id)
        ).perform(click())
    }
}