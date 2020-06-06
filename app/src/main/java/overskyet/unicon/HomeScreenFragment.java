package overskyet.unicon;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

import overskyet.unicon.utils.Animation;

public class HomeScreenFragment extends Fragment {

    private Intent mIntent;

    public HomeScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_screen_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {

        final Button buttonCurrency = v.findViewById(R.id.button_currency);
        final Button buttonTime = v.findViewById(R.id.button_time);
        final Button buttonFuelConsumption = v.findViewById(R.id.button_fuel_consumption);
        final Button buttonPressure = v.findViewById(R.id.button_pressure);
        final Button buttonEnergy = v.findViewById(R.id.button_energy);
        final Button buttonTemperature = v.findViewById(R.id.button_temperature);
        final Button buttonLength = v.findViewById(R.id.button_length);
        final Button buttonWeight = v.findViewById(R.id.button_weight);
        final Button buttonVolume = v.findViewById(R.id.button_volume);
        final Button buttonArea = v.findViewById(R.id.button_area);
        final Button buttonAngle = v.findViewById(R.id.button_angle);
        final Button buttonSpeed = v.findViewById(R.id.button_speed);

        buttonCurrency.setOnClickListener(view -> {

            ObjectAnimator animWidth = ObjectAnimator.ofInt(view, "width", view.getWidth() + Animation.getScreenWidth());
            animWidth.addUpdateListener(animation -> {
                view.getLayoutParams().width = (Integer) animation.getAnimatedValue();
                view.requestLayout();
            });
            animWidth.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    startActivity(mIntent);
                    buttonCurrency.refreshDrawableState();
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animatorSet.play(animWidth);
            animatorSet.start();

            mIntent = initIntent(CurrencyExchangeScreen.class,
                    getResources().getString(R.string.currency_button),
                    R.drawable.ic_currency_white,
                    null,
                    HomeScreen.KEY_1_CURRENCY_CONVERSION,
                    HomeScreen.KEY_2_CURRENCY_CONVERSION);
        });

        buttonTime.setOnClickListener(view -> {
            mIntent = initIntent(UnitsConversionScreen.class,
                    getResources().getString(R.string.time_button),
                    R.drawable.ic_time_white,
                    getResources().getStringArray(R.array.time_block),
                    HomeScreen.KEY_1_TIME_CONVERSION,
                    HomeScreen.KEY_2_TIME_CONVERSION);
            startActivity(mIntent);
        });

        buttonFuelConsumption.setOnClickListener(view -> {
            mIntent = initIntent(UnitsConversionScreen.class,
                    getResources().getString(R.string.fuel_consumption_button),
                    R.drawable.ic_fuel_consumption_white,
                    getResources().getStringArray(R.array.fuel_consumption_block),
                    HomeScreen.KEY_1_FUEL_CONSUMPTION_CONVERSION,
                    HomeScreen.KEY_2_FUEL_CONSUMPTION_CONVERSION);
            startActivity(mIntent);
        });

        buttonPressure.setOnClickListener(view -> {
            mIntent = initIntent(UnitsConversionScreen.class,
                    getResources().getString(R.string.pressure_button),
                    R.drawable.ic_pressure_white,
                    getResources().getStringArray(R.array.pressure_block),
                    HomeScreen.KEY_1_PRESSURE_CONVERSION,
                    HomeScreen.KEY_2_PRESSURE_CONVERSION);
            startActivity(mIntent);
        });

        buttonEnergy.setOnClickListener(view -> {
            mIntent = initIntent(UnitsConversionScreen.class,
                    getResources().getString(R.string.energy_button),
                    R.drawable.ic_energy_white,
                    getResources().getStringArray(R.array.energy_block),
                    HomeScreen.KEY_1_ENERGY_CONVERSION,
                    HomeScreen.KEY_2_ENERGY_CONVERSION);
            startActivity(mIntent);
        });

        buttonTemperature.setOnClickListener(view -> {
            mIntent = initIntent(UnitsConversionScreen.class,
                    getResources().getString(R.string.temperature_button),
                    R.drawable.ic_temperature_white,
                    getResources().getStringArray(R.array.temperature_block),
                    HomeScreen.KEY_1_TEMPERATURE_CONVERSION,
                    HomeScreen.KEY_2_TEMPERATURE_CONVERSION);
            startActivity(mIntent);
        });

        buttonLength.setOnClickListener(view -> {
            mIntent = initIntent(UnitsConversionScreen.class,
                    getResources().getString(R.string.length_button),
                    R.drawable.ic_length_white,
                    getResources().getStringArray(R.array.length_block),
                    HomeScreen.KEY_1_LENGTH_CONVERSION,
                    HomeScreen.KEY_2_LENGTH_CONVERSION);
            startActivity(mIntent);
        });

        buttonWeight.setOnClickListener(view -> {
            mIntent = initIntent(UnitsConversionScreen.class,
                    getResources().getString(R.string.weight_button),
                    R.drawable.ic_weight_white,
                    getResources().getStringArray(R.array.weight_block),
                    HomeScreen.KEY_1_WEIGHT_CONVERSION,
                    HomeScreen.KEY_2_WEIGHT_CONVERSION);
            startActivity(mIntent);
        });

        buttonVolume.setOnClickListener(view -> {
            mIntent = initIntent(UnitsConversionScreen.class,
                    getResources().getString(R.string.volume_button),
                    R.drawable.ic_volume_white,
                    getResources().getStringArray(R.array.volume_block),
                    HomeScreen.KEY_1_VOLUME_CONVERSION,
                    HomeScreen.KEY_2_VOLUME_CONVERSION);
            startActivity(mIntent);
        });

        buttonArea.setOnClickListener(view -> {
            mIntent = initIntent(UnitsConversionScreen.class,
                    getResources().getString(R.string.area_button),
                    R.drawable.ic_area_white,
                    getResources().getStringArray(R.array.area_block),
                    HomeScreen.KEY_1_AREA_CONVERSION,
                    HomeScreen.KEY_2_AREA_CONVERSION);
            startActivity(mIntent);
        });

        buttonAngle.setOnClickListener(view -> {
            mIntent = initIntent(UnitsConversionScreen.class,
                    getResources().getString(R.string.angle_button),
                    R.drawable.ic_angle_white,
                    getResources().getStringArray(R.array.angle_block),
                    HomeScreen.KEY_1_ANGLE_CONVERSION,
                    HomeScreen.KEY_2_ANGLE_CONVERSION);
            startActivity(mIntent);
        });

        buttonSpeed.setOnClickListener(view -> {
            mIntent = initIntent(UnitsConversionScreen.class,
                    getResources().getString(R.string.speed_button),
                    R.drawable.ic_speed_white,
                    getResources().getStringArray(R.array.speed_block),
                    HomeScreen.KEY_1_SPEED_CONVERSION,
                    HomeScreen.KEY_2_SPEED_CONVERSION);
            startActivity(mIntent);
        });
    }

    private Intent initIntent(Class<?> cls, String activityTitle, int activityImage, @Nullable String[] spinnerItems, String key1, String key2) {
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtra("stringExtra1", key1);
        intent.putExtra("stringExtra2", key2);
        intent.putExtra("stringExtra3", activityTitle);
        intent.putExtra("intExtra", activityImage);
        intent.putExtra("stringArrayExtra", spinnerItems);
        return intent;
    }

    //TODO Start UnitsScreen and CurrencyScreen through NavController
    //TODO What to do with intent data?

}
