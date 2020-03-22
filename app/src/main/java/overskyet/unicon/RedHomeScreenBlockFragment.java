package overskyet.unicon;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class RedHomeScreenBlockFragment extends Fragment {

    private Intent myIntent;

    public RedHomeScreenBlockFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_red_home_screen_block, container, false);

        Button buttonCurrency = v.findViewById(R.id.button_currency);
        Button buttonTime = v.findViewById(R.id.button_time);
        Button buttonFuelConsumption = v.findViewById(R.id.button_fuel_consumption);
        Button buttonPressure = v.findViewById(R.id.button_pressure);
        Button buttonEnergy = v.findViewById(R.id.button_energy);
        Button buttonTemperature = v.findViewById(R.id.button_temperature);

        buttonCurrency.setOnClickListener(view -> {
            myIntent = new Intent(getActivity(), CurrencyExchangeScreen.class);
            String activityTitle = getResources().getString(R.string.currency_button);
            int activityImage = R.drawable.ic_currency_white;
            myIntent.putExtra("stringExtra1", HomeScreen.KEY_1_CURRENCY_CONVERSION);
            myIntent.putExtra("stringExtra2", HomeScreen.KEY_2_CURRENCY_CONVERSION);
            myIntent.putExtra("stringExtra3", activityTitle);
            myIntent.putExtra("intExtra", activityImage);
            startActivity(myIntent);
        });

        buttonTime.setOnClickListener(view -> {
            myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.time_button);
            int activityImage = R.drawable.ic_time_white;
            String[] spinnerItems = getResources().getStringArray(R.array.time_block);
            myIntent.putExtra("stringExtra1", HomeScreen.KEY_1_TIME_CONVERSION);
            myIntent.putExtra("stringExtra2", HomeScreen.KEY_2_TIME_CONVERSION);
            myIntent.putExtra("stringExtra3", activityTitle);
            myIntent.putExtra("intExtra", activityImage);
            myIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(myIntent);
        });

        buttonFuelConsumption.setOnClickListener(view -> {
            myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.fuel_consumption_button);
            int activityImage = R.drawable.ic_fuel_consumption_white;
            String[] spinnerItems = getResources().getStringArray(R.array.fuel_consumption_block);
            myIntent.putExtra("stringExtra1", HomeScreen.KEY_1_FUEL_CONSUMPTION_CONVERSION);
            myIntent.putExtra("stringExtra2", HomeScreen.KEY_2_FUEL_CONSUMPTION_CONVERSION);
            myIntent.putExtra("stringExtra3", activityTitle);
            myIntent.putExtra("intExtra", activityImage);
            myIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(myIntent);
        });

        buttonPressure.setOnClickListener(view -> {
            myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.pressure_button);
            int activityImage = R.drawable.ic_pressure_white;
            String[] spinnerItems = getResources().getStringArray(R.array.pressure_block);
            myIntent.putExtra("stringExtra1", HomeScreen.KEY_1_PRESSURE_CONVERSION);
            myIntent.putExtra("stringExtra2", HomeScreen.KEY_2_PRESSURE_CONVERSION);
            myIntent.putExtra("stringExtra3", activityTitle);
            myIntent.putExtra("intExtra", activityImage);
            myIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(myIntent);
        });

        buttonEnergy.setOnClickListener(view -> {
            myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.energy_button);
            int activityImage = R.drawable.ic_energy_white;
            String[] spinnerItems = getResources().getStringArray(R.array.energy_block);
            myIntent.putExtra("stringExtra1", HomeScreen.KEY_1_ENERGY_CONVERSION);
            myIntent.putExtra("stringExtra2", HomeScreen.KEY_2_ENERGY_CONVERSION);
            myIntent.putExtra("stringExtra3", activityTitle);
            myIntent.putExtra("intExtra", activityImage);
            myIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(myIntent);
        });

        buttonTemperature.setOnClickListener(view -> {
            myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.temperature_button);
            int activityImage = R.drawable.ic_temperature_white;
            String[] spinnerItems = getResources().getStringArray(R.array.temperature_block);
            myIntent.putExtra("stringExtra1", HomeScreen.KEY_1_TEMPERATURE_CONVERSION);
            myIntent.putExtra("stringExtra2", HomeScreen.KEY_2_TEMPERATURE_CONVERSION);
            myIntent.putExtra("stringExtra3", activityTitle);
            myIntent.putExtra("intExtra", activityImage);
            myIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(myIntent);
        });

        return v;
    }
}
