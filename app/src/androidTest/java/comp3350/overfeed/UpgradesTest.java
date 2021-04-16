package comp3350.overfeed;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import comp3350.overfeed.presentation.MainActivity;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UpgradesTest
{
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void upgradeTest()
    {
        for(int i=0; i<15; i++)
        {
            onView(withId(R.id.imageButtonPlate)).perform(click());
        }

        onView(withId(R.id.buttonUpgrades)).perform(click());
        onView(withId(R.id.plateUpgradeButton)).perform(click());

        pressBack();

        for(int i=0; i<50; i++)
        {
            onView(withId(R.id.imageButtonPlate)).perform(click());
        }

        onView(withId(R.id.buttonUpgrades)).perform(click());
        onView(withId(R.id.workerUpgradeButton)).perform(click());

        pressBack();

        try
        {
            Thread.sleep(5000);

            onView(withId(R.id.counterView)).check(matches(withText("25")));
        }
        catch(Exception e)
        {

        }

    }
}
