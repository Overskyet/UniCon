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
public class BlueHomeScreenBlockFragment extends Fragment {

    private Intent myIntent;

    public BlueHomeScreenBlockFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blue_home_screen_block, container, false);

        Button buttonLength = v.findViewById(R.id.button_length);
        Button buttonWeight = v.findViewById(R.id.button_weight);
        Button buttonVolume = v.findViewById(R.id.button_volume);
        Button buttonArea = v.findViewById(R.id.button_area);
        Button buttonAngle = v.findViewById(R.id.button_angle);
        Button buttonSpeed = v.findViewById(R.id.button_speed);

        buttonLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
                String activityTitle = getResources().getString(R.string.length_button);
                String key1 = getResources().getString(R.string.preference_key_1_length_conversion);
                String key2 = getResources().getString(R.string.preference_key_2_length_conversion);
                String[] spinnerItems = getResources().getStringArray(R.array.length_block);
                myIntent.putExtra("stringExtra1", key1);
                myIntent.putExtra("stringExtra2", key2);
                myIntent.putExtra("stringExtra3", activityTitle);
                myIntent.putExtra("stringArrayExtra", spinnerItems);
                startActivity(myIntent);
            }
        });

        buttonWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
                String activityTitle = getResources().getString(R.string.weight_button);
                String key1 = getResources().getString(R.string.preference_key_1_weight_conversion);
                String key2 = getResources().getString(R.string.preference_key_2_weight_conversion);
                String[] spinnerItems = getResources().getStringArray(R.array.weight_block);
                myIntent.putExtra("stringExtra1", key1);
                myIntent.putExtra("stringExtra2", key2);
                myIntent.putExtra("stringExtra3", activityTitle);
                myIntent.putExtra("stringArrayExtra", spinnerItems);
                startActivity(myIntent);
            }
        });

        buttonVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
                String activityTitle = getResources().getString(R.string.volume_button);
                String key1 = getResources().getString(R.string.preference_key_1_volume_conversion);
                String key2 = getResources().getString(R.string.preference_key_2_volume_conversion);
                String[] spinnerItems = getResources().getStringArray(R.array.volume_block);
                myIntent.putExtra("stringExtra1", key1);
                myIntent.putExtra("stringExtra2", key2);
                myIntent.putExtra("stringExtra3", activityTitle);
                myIntent.putExtra("stringArrayExtra", spinnerItems);
                startActivity(myIntent);
            }
        });

        buttonArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
                String activityTitle = getResources().getString(R.string.area_button);
                String key1 = getResources().getString(R.string.preference_key_1_area_conversion);
                String key2 = getResources().getString(R.string.preference_key_2_area_conversion);
                String[] spinnerItems = getResources().getStringArray(R.array.area_block);
                myIntent.putExtra("stringExtra1", key1);
                myIntent.putExtra("stringExtra2", key2);
                myIntent.putExtra("stringExtra3", activityTitle);
                myIntent.putExtra("stringArrayExtra", spinnerItems);
                startActivity(myIntent);
            }
        });

        buttonAngle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
                String activityTitle = getResources().getString(R.string.angle_button);
                String key1 = getResources().getString(R.string.preference_key_1_angle_conversion);
                String key2 = getResources().getString(R.string.preference_key_2_angle_conversion);
                String[] spinnerItems = getResources().getStringArray(R.array.angle_block);
                myIntent.putExtra("stringExtra1", key1);
                myIntent.putExtra("stringExtra2", key2);
                myIntent.putExtra("stringExtra3", activityTitle);
                myIntent.putExtra("stringArrayExtra", spinnerItems);
                startActivity(myIntent);
            }
        });

        buttonSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
                String activityTitle = getResources().getString(R.string.speed_button);
                String key1 = getResources().getString(R.string.preference_key_1_speed_conversion);
                String key2 = getResources().getString(R.string.preference_key_2_speed_conversion);
                String[] spinnerItems = getResources().getStringArray(R.array.speed_block);
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
