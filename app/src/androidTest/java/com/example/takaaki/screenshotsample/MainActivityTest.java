package com.example.takaaki.screenshotsample;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.example.takaaki.screenshotsample.ScreenshotViewAction.screenshot;
import static org.hamcrest.Matchers.allOf;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.facebook.testing.screenshot.Screenshot;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

  @Rule
  public ActivityTestRule<MainActivity> activityTestRule =
    new ActivityTestRule<>(MainActivity.class, true, false);

  @Test
  public void mainActivityTest() {
    final MainActivity activity = activityTestRule.launchActivity(null);

    Screenshot.snapActivity(activity).record();
  }


  @Test
  public void mainActivityTestFabWithEspresso() {
    activityTestRule.launchActivity(null);
    onView(withId(R.id.fab)).perform(screenshot("fab"));
  }
}
