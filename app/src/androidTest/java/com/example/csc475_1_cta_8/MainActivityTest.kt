package com.example.csc475_1_cta_8

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.Matchers.allOf
import android.widget.CalendarView

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun clickAddTaskButtonAddTaskNoInfoThenBack() {
        Espresso.onView(ViewMatchers.withId(R.id.addTaskButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.addTaskContainer))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(allOf(ViewMatchers.withId(R.id.calendarViewAddTask), ViewMatchers.isAssignableFrom(CalendarView::class.java)))
            .perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(allOf(ViewMatchers.withId(R.id.calendarViewAddTask), ViewMatchers.isAssignableFrom(CalendarView::class.java)))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.saveButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.backButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.mainActivityContainer))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun clickAddTaskButtonAddTaskThenSave() {
        Espresso.onView(ViewMatchers.withId(R.id.addTaskButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.addTaskContainer))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.taskNameInput))
            .perform(ViewActions.typeText("Task name"))

        Espresso.onView(ViewMatchers.withId(R.id.taskDescriptionInput))
            .perform(ViewActions.typeText("Task description"))

        Espresso.onView(allOf(ViewMatchers.withId(R.id.calendarViewAddTask), ViewMatchers.isAssignableFrom(CalendarView::class.java)))
            .perform(ViewActions.closeSoftKeyboard())

        Espresso.onView(ViewMatchers.withId(R.id.saveButton))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.mainActivityContainer))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.taskList))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.taskCompleted))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.taskCompleted))
            .perform(ViewActions.click())
    }
}