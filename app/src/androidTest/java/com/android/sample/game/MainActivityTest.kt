package com.android.sample.game

import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun shouldBeAbleToLaunchTitleScreen() {
        onView(withId(R.id.game_title)).check(matches(isDisplayed()))
        onView(withId(R.id.title_image)).check(matches(isDisplayed()))
        onView(withId(R.id.play_btn)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldBeAbleToLaunchRegisterScreen() {
        onView(withId(R.id.play_btn)).perform(click())
        onView(withText(R.string.question_1)).check(matches(isDisplayed()))
        onView(withId(R.id.ImageView)).check(matches(isDisplayed()))
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
        onView(withId(R.id.user_text_layout)).check(matches(isDisplayed()))
        onView(withId(R.id.user_text)).check(matches(isDisplayed()))
        onView(withId(R.id.register_btn)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldBeAbleToLaunchInGameScreen() {
        onView(withId(R.id.play_btn)).perform(click())
        onView(isAssignableFrom(EditText::class.java))
            .perform(typeText("a"), pressImeActionButton())
        onView(withId(R.id.register_btn)).perform(click())
        onView(withText(R.string.question_2)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
        onView(withId(R.id.user_guess_layout)).check(matches(isDisplayed()))
        onView(withId(R.id.user_guess)).check(matches(isDisplayed()))
        onView(withId(R.id.register_btn)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldBeAbleToLaunchWinnerScreen() {
        onView(withId(R.id.play_btn)).perform(click())
        onView(isAssignableFrom(EditText::class.java))
            .perform(typeText("a"), pressImeActionButton())
        onView(withId(R.id.register_btn)).perform(click())
        onView(isAssignableFrom(EditText::class.java))
            .perform(typeText("a"), pressImeActionButton())
        onView(withId(R.id.register_btn)).perform(click())
        onView(withText(R.string.congratulations)).check(matches(isDisplayed()))
        onView(withId(R.id.game_title)).check(matches(isDisplayed()))
        onView(withId(R.id.title_image)).check(matches(isDisplayed()))
        onView(withId(R.id.win_btn)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldBeAbleToReLaunchTitleSreenAfterWinning() {
        onView(withId(R.id.play_btn)).perform(click())
        onView(isAssignableFrom(EditText::class.java))
            .perform(typeText("a"), pressImeActionButton())
        onView(withId(R.id.register_btn)).perform(click())
        onView(isAssignableFrom(EditText::class.java))
            .perform(typeText("a"), pressImeActionButton())
        onView(withId(R.id.register_btn)).perform(click())
        onView(withId(R.id.win_btn)).perform(click())
        onView(withId(R.id.game_title)).check(matches(isDisplayed()))
        onView(withId(R.id.title_image)).check(matches(isDisplayed()))
        onView(withId(R.id.play_btn)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldBeAbleToLaunchGameOverScreen() {
        onView(withId(R.id.play_btn)).perform(click())
        onView(isAssignableFrom(EditText::class.java))
            .perform(typeText("a"), pressImeActionButton())
        onView(withId(R.id.register_btn)).perform(click())
        onView(isAssignableFrom(EditText::class.java))
            .perform(typeText("b"), pressImeActionButton())
        onView(withId(R.id.register_btn)).perform(click())
        onView(withText(R.string.game_over)).check(matches(isDisplayed()))
        onView(withId(R.id.game_title)).check(matches(isDisplayed()))
        onView(withId(R.id.game_over_btn)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldBeAbleToLaunchTitleScreenAfterGameOver() {
        onView(withId(R.id.play_btn)).perform(click())
        onView(isAssignableFrom(EditText::class.java))
            .perform(typeText("a"), pressImeActionButton())
        onView(withId(R.id.register_btn)).perform(click())
        onView(isAssignableFrom(EditText::class.java))
            .perform(typeText("b"), pressImeActionButton())
        onView(withId(R.id.register_btn)).perform(click())
        onView(withId(R.id.game_over_btn)).perform(click())
        onView(withId(R.id.game_title)).check(matches(isDisplayed()))
        onView(withId(R.id.title_image)).check(matches(isDisplayed()))
        onView(withId(R.id.play_btn)).check(matches(isDisplayed()))
    }
}