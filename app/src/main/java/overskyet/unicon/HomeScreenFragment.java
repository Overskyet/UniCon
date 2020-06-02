package overskyet.unicon;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeScreenFragment extends Fragment {

    private Intent mIntent;

    public HomeScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.home_screen_fragment, container, false);

        Button buttonCurrency = v.findViewById(R.id.button_currency);
        Button buttonTime = v.findViewById(R.id.button_time);
        Button buttonFuelConsumption = v.findViewById(R.id.button_fuel_consumption);
        Button buttonPressure = v.findViewById(R.id.button_pressure);
        Button buttonEnergy = v.findViewById(R.id.button_energy);
        Button buttonTemperature = v.findViewById(R.id.button_temperature);
        Button buttonLength = v.findViewById(R.id.button_length);
        Button buttonWeight = v.findViewById(R.id.button_weight);
        Button buttonVolume = v.findViewById(R.id.button_volume);
        Button buttonArea = v.findViewById(R.id.button_area);
        Button buttonAngle = v.findViewById(R.id.button_angle);
        Button buttonSpeed = v.findViewById(R.id.button_speed);

        buttonCurrency.setOnClickListener(view -> {
            mIntent = new Intent(getActivity(), CurrencyExchangeScreen.class);
            String activityTitle = getResources().getString(R.string.currency_button);
            int activityImage = R.drawable.ic_currency_white;
            mIntent.putExtra("stringExtra1", HomeScreen.KEY_1_CURRENCY_CONVERSION);
            mIntent.putExtra("stringExtra2", HomeScreen.KEY_2_CURRENCY_CONVERSION);
            mIntent.putExtra("stringExtra3", activityTitle);
            mIntent.putExtra("intExtra", activityImage);
            startActivity(mIntent);
        });

        buttonTime.setOnClickListener(view -> {
            mIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.time_button);
            int activityImage = R.drawable.ic_time_white;
            String[] spinnerItems = getResources().getStringArray(R.array.time_block);
            mIntent.putExtra("stringExtra1", HomeScreen.KEY_1_TIME_CONVERSION);
            mIntent.putExtra("stringExtra2", HomeScreen.KEY_2_TIME_CONVERSION);
            mIntent.putExtra("stringExtra3", activityTitle);
            mIntent.putExtra("intExtra", activityImage);
            mIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(mIntent);
        });

        buttonFuelConsumption.setOnClickListener(view -> {
            mIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.fuel_consumption_button);
            int activityImage = R.drawable.ic_fuel_consumption_white;
            String[] spinnerItems = getResources().getStringArray(R.array.fuel_consumption_block);
            mIntent.putExtra("stringExtra1", HomeScreen.KEY_1_FUEL_CONSUMPTION_CONVERSION);
            mIntent.putExtra("stringExtra2", HomeScreen.KEY_2_FUEL_CONSUMPTION_CONVERSION);
            mIntent.putExtra("stringExtra3", activityTitle);
            mIntent.putExtra("intExtra", activityImage);
            mIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(mIntent);
        });

        buttonPressure.setOnClickListener(view -> {
            mIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.pressure_button);
            int activityImage = R.drawable.ic_pressure_white;
            String[] spinnerItems = getResources().getStringArray(R.array.pressure_block);
            mIntent.putExtra("stringExtra1", HomeScreen.KEY_1_PRESSURE_CONVERSION);
            mIntent.putExtra("stringExtra2", HomeScreen.KEY_2_PRESSURE_CONVERSION);
            mIntent.putExtra("stringExtra3", activityTitle);
            mIntent.putExtra("intExtra", activityImage);
            mIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(mIntent);
        });

        buttonEnergy.setOnClickListener(view -> {
            mIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.energy_button);
            int activityImage = R.drawable.ic_energy_white;
            String[] spinnerItems = getResources().getStringArray(R.array.energy_block);
            mIntent.putExtra("stringExtra1", HomeScreen.KEY_1_ENERGY_CONVERSION);
            mIntent.putExtra("stringExtra2", HomeScreen.KEY_2_ENERGY_CONVERSION);
            mIntent.putExtra("stringExtra3", activityTitle);
            mIntent.putExtra("intExtra", activityImage);
            mIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(mIntent);
        });

        buttonTemperature.setOnClickListener(view -> {
            mIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.temperature_button);
            int activityImage = R.drawable.ic_temperature_white;
            String[] spinnerItems = getResources().getStringArray(R.array.temperature_block);
            mIntent.putExtra("stringExtra1", HomeScreen.KEY_1_TEMPERATURE_CONVERSION);
            mIntent.putExtra("stringExtra2", HomeScreen.KEY_2_TEMPERATURE_CONVERSION);
            mIntent.putExtra("stringExtra3", activityTitle);
            mIntent.putExtra("intExtra", activityImage);
            mIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(mIntent);
        });

        buttonLength.setOnClickListener(view -> {
            mIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.length_button);
            int activityImage = R.drawable.ic_length_white;
            String[] spinnerItems = getResources().getStringArray(R.array.length_block);
            mIntent.putExtra("stringExtra1", HomeScreen.KEY_1_LENGTH_CONVERSION);
            mIntent.putExtra("stringExtra2", HomeScreen.KEY_2_LENGTH_CONVERSION);
            mIntent.putExtra("stringExtra3", activityTitle);
            mIntent.putExtra("intExtra", activityImage);
            mIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(mIntent);
        });

        buttonWeight.setOnClickListener(view -> {
            mIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.weight_button);
            int activityImage = R.drawable.ic_weight_white;
            String[] spinnerItems = getResources().getStringArray(R.array.weight_block);
            mIntent.putExtra("stringExtra1", HomeScreen.KEY_1_WEIGHT_CONVERSION);
            mIntent.putExtra("stringExtra2", HomeScreen.KEY_2_WEIGHT_CONVERSION);
            mIntent.putExtra("stringExtra3", activityTitle);
            mIntent.putExtra("intExtra", activityImage);
            mIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(mIntent);
        });

        buttonVolume.setOnClickListener(view -> {
            mIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.volume_button);
            int activityImage = R.drawable.ic_volume_white;
            String[] spinnerItems = getResources().getStringArray(R.array.volume_block);
            mIntent.putExtra("stringExtra1", HomeScreen.KEY_1_VOLUME_CONVERSION);
            mIntent.putExtra("stringExtra2", HomeScreen.KEY_2_VOLUME_CONVERSION);
            mIntent.putExtra("stringExtra3", activityTitle);
            mIntent.putExtra("intExtra", activityImage);
            mIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(mIntent);
        });

        buttonArea.setOnClickListener(view -> {
            mIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.area_button);
            int activityImage = R.drawable.ic_area_white;
            String[] spinnerItems = getResources().getStringArray(R.array.area_block);
            mIntent.putExtra("stringExtra1", HomeScreen.KEY_1_AREA_CONVERSION);
            mIntent.putExtra("stringExtra2", HomeScreen.KEY_2_AREA_CONVERSION);
            mIntent.putExtra("stringExtra3", activityTitle);
            mIntent.putExtra("intExtra", activityImage);
            mIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(mIntent);
        });

        buttonAngle.setOnClickListener(view -> {
            mIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.angle_button);
            int activityImage = R.drawable.ic_angle_white;
            String[] spinnerItems = getResources().getStringArray(R.array.angle_block);
            mIntent.putExtra("stringExtra1", HomeScreen.KEY_1_ANGLE_CONVERSION);
            mIntent.putExtra("stringExtra2", HomeScreen.KEY_2_ANGLE_CONVERSION);
            mIntent.putExtra("stringExtra3", activityTitle);
            mIntent.putExtra("intExtra", activityImage);
            mIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(mIntent);
        });

        buttonSpeed.setOnClickListener(view -> {
            mIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.speed_button);
            int activityImage = R.drawable.ic_speed_white;
            String[] spinnerItems = getResources().getStringArray(R.array.speed_block);
            mIntent.putExtra("stringExtra1", HomeScreen.KEY_1_SPEED_CONVERSION);
            mIntent.putExtra("stringExtra2", HomeScreen.KEY_2_SPEED_CONVERSION);
            mIntent.putExtra("stringExtra3", activityTitle);
            mIntent.putExtra("intExtra", activityImage);
            mIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(mIntent);
        });

        return v;
    }
}
