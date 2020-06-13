package overskyet.unicon;

import androidx.test.filters.LargeTest;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import overskyet.unicon.ui.fragments.UnitsConversionFragment;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<UnitsConversionFragment> activityTestRule = new ActivityTestRule<>(UnitsConversionFragment.class);

    @Test
    public void checkFirstLaunch() {
       /* onView(withId(R.id.button_0))
                .perform(click())
                .check(matches(isDisplayed()));*/
    }
}
