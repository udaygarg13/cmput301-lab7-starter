package com.example.androiduitesting;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ShowActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> scenario = new
            ActivityScenarioRule<MainActivity>(MainActivity.class);
    @Test
    public void testSwitch(){
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Edmonton"));
        onView(withId(R.id.button_confirm)).perform(click());

        onView(withText("Edmonton")).check(matches(isDisplayed()));
        onView(withText("Edmonton")).perform(click());
        onView(withId(R.id.button_back)).check(matches((isDisplayed())));
    }

    @Test
    public void testCityConsistency(){
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Edmonton"));
        onView(withId(R.id.button_confirm)).perform(click());

        onView(withText("Edmonton")).check(matches(isDisplayed()));
        onView(withText("Edmonton")).perform(click());
        onView(withId(R.id.field_nameEntry)).check(matches(withText("Edmonton")));
    }

    @Test
    public void testBackButton(){
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Edmonton"));
        onView(withId(R.id.button_confirm)).perform(click());

        onView(withText("Edmonton")).check(matches(isDisplayed()));
        onView(withText("Edmonton")).perform(click());

        onView(withId(R.id.button_back)).check(matches((isDisplayed())));
        onView(withId(R.id.button_back)).perform(click());
        onView(withId(R.id.button_back)).check(matches((isDisplayed())));

        try {
            Thread.sleep(4700);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}