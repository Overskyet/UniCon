package overskyet.unicon;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
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

        buttonCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), CurrencyExchangeScreen.class);
                String activityTitle = getResources().getString(R.string.currency_button);
                String key1 = getResources().getString(R.string.preference_key_1_currency_conversion);
                String key2 = getResources().getString(R.string.preference_key_2_currency_conversion);
                myIntent.putExtra("stringExtra1", key1);
                myIntent.putExtra("stringExtra2", key2);
                myIntent.putExtra("stringExtra3", activityTitle);
                startActivity(myIntent);
            }
        });

        buttonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
                String activityTitle = getResources().getString(R.string.time_button);
                String key1 = getResources().getString(R.string.preference_key_1_time_conversion);
                String key2 = getResources().getString(R.string.preference_key_2_time_conversion);
                String[] spinnerItems = getResources().getStringArray(R.array.time_block);
                myIntent.putExtra("stringExtra1", key1);
                myIntent.putExtra("stringExtra2", key2);
                myIntent.putExtra("stringExtra3", activityTitle);
                myIntent.putExtra("stringArrayExtra", spinnerItems);
                startActivity(myIntent);
            }
        });

        buttonFuelConsumption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
                String activityTitle = getResources().getString(R.string.fuel_consumption_button);
                String key1 = getResources().getString(R.string.preference_key_1_fuel_consumption_conversion);
                String key2 = getResources().getString(R.string.preference_key_2_fuel_consumption_conversion);
                String[] spinnerItems = getResources().getStringArray(R.array.fuel_consumption_block);
                myIntent.putExtra("stringExtra1", key1);
                myIntent.putExtra("stringExtra2", key2);
                myIntent.putExtra("stringExtra3", activityTitle);
                myIntent.putExtra("stringArrayExtra", spinnerItems);
                startActivity(myIntent);
            }
        });

        buttonPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
                String activityTitle = getResources().getString(R.string.pressure_button);
                String key1 = getResources().getString(R.string.preference_key_1_pressure_conversion);
                String key2 = getResources().getString(R.string.preference_key_2_pressure_conversion);
                String[] spinnerItems = getResources().getStringArray(R.array.pressure_block);
                myIntent.putExtra("stringExtra1", key1);
                myIntent.putExtra("stringExtra2", key2);
                myIntent.putExtra("stringExtra3", activityTitle);
                myIntent.putExtra("stringArrayExtra", spinnerItems);
                startActivity(myIntent);
            }
        });

        buttonEnergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
                String activityTitle = getResources().getString(R.string.energy_button);
                String key1 = getResources().getString(R.string.preference_key_1_energy_conversion);
                String key2 = getResources().getString(R.string.preference_key_2_energy_conversion);
                String[] spinnerItems = getResources().getStringArray(R.array.energy_block);
                myIntent.putExtra("stringExtra1", key1);
                myIntent.putExtra("stringExtra2", key2);
                myIntent.putExtra("stringExtra3", activityTitle);
                myIntent.putExtra("stringArrayExtra", spinnerItems);
                startActivity(myIntent);
            }
        });

        buttonTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
                String activityTitle = getResources().getString(R.string.temperature_button);
                String key1 = getResources().getString(R.string.preference_key_1_temperature_conversion);
                String key2 = getResources().getString(R.string.preference_key_2_temperature_conversion);
                String[] spinnerItems = getResources().getStringArray(R.array.temperature_block);
                myIntent.putExtra("stringExtra1", key1);
                myIntent.putExtra("stringExtra2", key2);
                myIntent.putExtra("stringExtra3", activityTitle);
                myIntent.putExtra("stringArrayExtra", spinnerItems);
                startActivity(myIntent);
            }
        });

        return v;
    }
}
