package com.alfdonyus.myapplication02

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering.Context

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

//    lateinit var mainActivityScenario: ActivityScenario<MainActivity>
//    @Before
//    fun setUp(){
//        mainActivityScenario= ActivityScenario.launch(MainActivity::class.java)
//    }
//
//    @After
//    fun tearDown(){
//        mainActivityScenario.close()
//    }

    @get:Rule
    var mainActivityScenario= ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testBlank(){
        val context= ApplicationProvider.getApplicationContext<android.content.Context>()
        val name= "Alfdonyus"
        onView(withId(R.id.nameEditText))
            .perform(typeText(name))
        onView(withId(R.id.sayHelloButton))
            .perform(click())
        onView(withId(R.id.sayHelloTextView))
            .check(matches(withText(context.getString(R.string.sayHelloTextView, name))))
        Thread.sleep(2000)
    }
}