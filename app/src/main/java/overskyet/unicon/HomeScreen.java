package overskyet.unicon;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import overskyet.unicon.adapters.HomeScreenFragmentAdapter;

public class HomeScreen extends AppCompatActivity {

    public static final String KEY_1_CURRENCY_CONVERSION = "overskyet.unicon.CURRENCY_SPINNER_1";
    public static final String KEY_1_TIME_CONVERSION = "overskyet.unicon.TIME_SPINNER_1";
    public static final String KEY_1_FUEL_CONSUMPTION_CONVERSION = "overskyet.unicon.FUEL_CONSUMPTION_SPINNER_1";
    public static final String KEY_1_PRESSURE_CONVERSION = "overskyet.unicon.PRESSURE_SPINNER_1";
    public static final String KEY_1_ENERGY_CONVERSION = "overskyet.unicon.ENERGY_SPINNER_1";
    public static final String KEY_1_TEMPERATURE_CONVERSION = "overskyet.unicon.TEMPERATURE_SPINNER_1";
    public static final String KEY_1_LENGTH_CONVERSION = "overskyet.unicon.LENGTH_SPINNER_1";
    public static final String KEY_1_WEIGHT_CONVERSION = "overskyet.unicon.WEIGHT_SPINNER_1";
    public static final String KEY_1_VOLUME_CONVERSION = "overskyet.unicon.VOLUME_SPINNER_1";
    public static final String KEY_1_AREA_CONVERSION = "overskyet.unicon.AREA_SPINNER_1";
    public static final String KEY_1_ANGLE_CONVERSION = "overskyet.unicon.ANGLE_SPINNER_1";
    public static final String KEY_1_SPEED_CONVERSION = "overskyet.unicon.SPEED_SPINNER_1";
    public static final String KEY_2_CURRENCY_CONVERSION = "overskyet.unicon.CURRENCY_SPINNER_2";
    public static final String KEY_2_TIME_CONVERSION = "overskyet.unicon.TIME_SPINNER_2";
    public static final String KEY_2_FUEL_CONSUMPTION_CONVERSION = "overskyet.unicon.FUEL_CONSUMPTION_SPINNER_2";
    public static final String KEY_2_PRESSURE_CONVERSION = "overskyet.unicon.PRESSURE_SPINNER_2";
    public static final String KEY_2_ENERGY_CONVERSION = "overskyet.unicon.ENERGY_SPINNER_2";
    public static final String KEY_2_TEMPERATURE_CONVERSION = "overskyet.unicon.TEMPERATURE_SPINNER_2";
    public static final String KEY_2_LENGTH_CONVERSION = "overskyet.unicon.LENGTH_SPINNER_2";
    public static final String KEY_2_WEIGHT_CONVERSION = "overskyet.unicon.WEIGHT_SPINNER_2";
    public static final String KEY_2_VOLUME_CONVERSION = "overskyet.unicon.VOLUME_SPINNER_2";
    public static final String KEY_2_AREA_CONVERSION = "overskyet.unicon.AREA_SPINNER_2";
    public static final String KEY_2_ANGLE_CONVERSION = "overskyet.unicon.ANGLE_SPINNER_2";
    public static final String KEY_2_SPEED_CONVERSION = "overskyet.unicon.SPEED_SPINNER_2";

    HomeScreenFragmentAdapter pageAdapter;
    RedHomeScreenBlockFragment redBlockFragment;
    BlueHomeScreenBlockFragment blueBlockFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        redBlockFragment = new RedHomeScreenBlockFragment();
        blueBlockFragment = new BlueHomeScreenBlockFragment();

        List<Fragment> fragments = getFragments();
        pageAdapter = new HomeScreenFragmentAdapter(getSupportFragmentManager(), fragments);
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(pageAdapter);

    }

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();

        fragments.add(redBlockFragment);
        fragments.add(blueBlockFragment);
        return fragments;
    }

}
