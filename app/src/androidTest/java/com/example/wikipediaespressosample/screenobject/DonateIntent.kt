package com.example.wikipediaespressosample.screenobject

import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData

class DonateIntent {
    fun checkIntent(){
        intended(
            (hasData("https://donate.wikimedia.org/?utm_medium=WikipediaApp&amp;utm_campaign=Android&amp;"))
        )
    }
}