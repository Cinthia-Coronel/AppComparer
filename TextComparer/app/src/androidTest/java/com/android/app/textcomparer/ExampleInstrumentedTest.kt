package com.android.app.textcomparer

import androidx.lifecycle.ViewModelProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testCompararButton() {
        Espresso.onView(ViewMatchers.withId(R.id.textView1))
            .perform(ViewActions.typeText("Text 1"), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.textView2))
            .perform(ViewActions.typeText("Text 2"), ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click())

        val activityScenario = activityRule.scenario
        activityScenario.onActivity { activity ->
            val viewModel = ViewModelProvider(activity).get(Comparer::class.java)
            val expectedResult = "Los textos son diferentes"
            assertEquals(expectedResult, viewModel.resultado.value)
        }
    }
}