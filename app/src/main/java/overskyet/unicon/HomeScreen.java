package overskyet.unicon;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.SystemClock;
import android.widget.Chronometer;

import java.util.ArrayList;
import java.util.List;

import overskyet.unicon.adapters.HomeScreenFragmentAdapter;
import overskyet.unicon.exchangerates.ExchangeRatesAsync;

public class HomeScreen extends AppCompatActivity {

    public static final String KEY_MAP_OF_RATES = "overskyet.unicon.MAP_OF_RATES";
    public static final String KEY_ECB_TIME_OF_UPDATE = "overskyet.unicon.TIME_OF_UPDATE";
    public static final String KEY_NEXT_UPDATE_TIME = "overskyet.unicon.NEXT_UPDATE_TIME";
    public static final String KEY_EXCHANGE_RATES_SHARED_PREFERENCES = "overskyet.unicon.EXCHANGE_RATES";
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

    DialogFragment disclaimerDialogFragment;
    HomeScreenFragmentAdapter pageAdapter;
    TabLayout tabLayout;
    Toolbar toolbar;
    private Boolean isFirstLaunch = true;


    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        initToolbar();

        //Start Scheduler here
        checkScheduler();

        pageAdapter = new HomeScreenFragmentAdapter(HomeScreen.this, getFragments());
        ViewPager2 viewPager = findViewById(R.id.home_screen_view_pager);
        viewPager.setAdapter(pageAdapter);

        tabLayout = findViewById(R.id.home_screen_tab_layout);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                }).attach();
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.home_screen_toolbar);
        toolbar.inflateMenu(R.menu.home_screen_toolbar_menu);
        toolbar.setOnMenuItemClickListener(menuItem -> {
            int i = menuItem.getItemId();

            if (i == R.id.item_credits) {
                openDialogWindow();
                return true;
            }
            return false;
        });
    }

    private void checkScheduler() {
        ExchangeRatesAsync exchangeRatesAsync = new ViewModelProvider(HomeScreen.this).get(ExchangeRatesAsync.class);
        if (isFirstLaunch) {
            checkFirstLaunch();
            exchangeRatesAsync.startAsyncTask();
        } else {
            chronometer = findViewById(R.id.home_screen_test_chronometer);
            if (exchangeRatesAsync.getStartTime() == null) {
                long startTime = SystemClock.elapsedRealtime();
                exchangeRatesAsync.setStartTime(startTime);
                chronometer.setBase(startTime);
            } else {
                chronometer.setBase(exchangeRatesAsync.getStartTime());
            }
            chronometer.start();
            exchangeRatesAsync.checkScheduleForAsync();
        }
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();

        fragments.add(new RedHomeScreenBlockFragment());
        fragments.add(new BlueHomeScreenBlockFragment());
        return fragments;
    }

    private void openDialogWindow() {
        disclaimerDialogFragment = new HomeScreenCreditsDialogFragment();
        disclaimerDialogFragment.show(getSupportFragmentManager(), getResources().getString(R.string.credits_header));
    }

    private void checkFirstLaunch() {
        isFirstLaunch = false;
    }
}
