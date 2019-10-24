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
public class RedMainActivityBlockFragment extends Fragment {

    private Intent myIntent;

    public RedMainActivityBlockFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_red_main_activity_block, container, false);

        Button buttonCurrency = v.findViewById(R.id.button_currency);
        Button buttonTime = v.findViewById(R.id.button_time);
        Button buttonFuelConsumption = v.findViewById(R.id.button_fuel_consumption);
        Button buttonPressure = v.findViewById(R.id.button_pressure);
        Button buttonEnergy = v.findViewById(R.id.button_energy);
        Button buttonTemperature = v.findViewById(R.id.button_temperature);

        buttonCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), CurrencyExchangeRatesActivity.class);
                startActivity(myIntent);
            }
        });

        buttonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), ConversionActivity.class);
                startActivity(myIntent);
            }
        });

        buttonFuelConsumption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), ConversionActivity.class);
                startActivity(myIntent);
            }
        });

        buttonPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), ConversionActivity.class);
                startActivity(myIntent);
            }
        });

        buttonEnergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), ConversionActivity.class);
                startActivity(myIntent);
            }
        });

        buttonTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), ConversionActivity.class);
                startActivity(myIntent);
            }
        });

        return v;
    }

}
