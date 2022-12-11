package com.example.wikipediaespressosample.screenobject

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.allOf
import org.wikipedia.R


class SettingsScreen {

    fun tapButtonRec(i: Int){
        onView(
            withId(R.id.recycler_view)
        ).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(i, click()))
    }

    fun tapButtonRec(text: String){
        onView(
            withId(R.id.recycler_view)
        ).perform(RecyclerViewActions.actionOnItem<RecyclerView.ViewHolder>(hasDescendant(withText(text)), click()))
    }

    fun tapBackButton(){
        onView(
            allOf(
                withParent(withId(R.id.action_bar)),
                hasSibling(withText("Settings")),
                hasSibling(withChild(withId(R.id.developer_settings)))
            )
        ).perform(click())
    }
}