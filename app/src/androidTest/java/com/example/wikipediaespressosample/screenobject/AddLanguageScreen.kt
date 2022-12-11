package com.example.wikipediaespressosample.screenobject

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import org.wikipedia.R

class AddAlanguageScreen {

    fun selectLanguage(text: String){
        onView(
            withId(R.id.languages_list_recycler)
        ).perform(RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(hasDescendant(withText(text)), click()))
    }

    fun search(){
        onView(
            withId(R.id.menu_search_language)
        ).perform(click())
    }

    fun enterText(text: String){
        onView(
            withId(R.id.search_src_text)
        ).perform(replaceText(text))
    }
}