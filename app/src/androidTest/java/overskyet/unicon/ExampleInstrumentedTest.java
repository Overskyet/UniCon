package overskyet.unicon;

import androidx.test.core.app.ActivityScenario;
import androidx.test.filters.LargeTest;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import overskyet.unicon.ui.activity.HomeScreenActivity;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenario<HomeScreenActivity> scenario = ActivityScenario.launch(HomeScreenActivity.class);

    @Test
    public void checkFirstLaunch() {
    }
}
