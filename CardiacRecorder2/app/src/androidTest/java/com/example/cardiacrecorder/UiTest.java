package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UiTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void test() {
        onView(withId(R.id.add_button)).perform(click());
        onView(withText("Add Record")).check(matches(isDisplayed()));
        onView(withId(R.id.time_input)).perform(ViewActions.typeText("4:30pm"));
        onView(withId(R.id.date_input)).perform(ViewActions.typeText("27/07/2020"));
        onView(withId(R.id.sp_input)).perform(ViewActions.typeText("100"));
        onView(withId(R.id.dp_input)).perform(ViewActions.typeText("70"));
        onView(withId(R.id.hr_input)).perform(ViewActions.typeText("66"));
        Espresso.pressBack();
        onView(withId(R.id.cmt_input)).perform(ViewActions.typeText("good"));
        Espresso.pressBack();
        onView(withId(R.id.add_button)).perform(click());
        Espresso.pressBack();
    }
}
