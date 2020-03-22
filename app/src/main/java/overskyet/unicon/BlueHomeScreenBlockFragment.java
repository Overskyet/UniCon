package overskyet.unicon;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

        buttonLength.setOnClickListener(view -> {
            myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.length_button);
            int activityImage = R.drawable.ic_length_white;
            String[] spinnerItems = getResources().getStringArray(R.array.length_block);
            myIntent.putExtra("stringExtra1", HomeScreen.KEY_1_LENGTH_CONVERSION);
            myIntent.putExtra("stringExtra2", HomeScreen.KEY_2_LENGTH_CONVERSION);
            myIntent.putExtra("stringExtra3", activityTitle);
            myIntent.putExtra("intExtra", activityImage);
            myIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(myIntent);
        });

        buttonWeight.setOnClickListener(view -> {
            myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.weight_button);
            int activityImage = R.drawable.ic_weight_white;
            String[] spinnerItems = getResources().getStringArray(R.array.weight_block);
            myIntent.putExtra("stringExtra1", HomeScreen.KEY_1_WEIGHT_CONVERSION);
            myIntent.putExtra("stringExtra2", HomeScreen.KEY_2_WEIGHT_CONVERSION);
            myIntent.putExtra("stringExtra3", activityTitle);
            myIntent.putExtra("intExtra", activityImage);
            myIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(myIntent);
        });

        buttonVolume.setOnClickListener(view -> {
            myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.volume_button);
            int activityImage = R.drawable.ic_volume_white;
            String[] spinnerItems = getResources().getStringArray(R.array.volume_block);
            myIntent.putExtra("stringExtra1", HomeScreen.KEY_1_VOLUME_CONVERSION);
            myIntent.putExtra("stringExtra2", HomeScreen.KEY_2_VOLUME_CONVERSION);
            myIntent.putExtra("stringExtra3", activityTitle);
            myIntent.putExtra("intExtra", activityImage);
            myIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(myIntent);
        });

        buttonArea.setOnClickListener(view -> {
            myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.area_button);
            int activityImage = R.drawable.ic_area_white;
            String[] spinnerItems = getResources().getStringArray(R.array.area_block);
            myIntent.putExtra("stringExtra1", HomeScreen.KEY_1_AREA_CONVERSION);
            myIntent.putExtra("stringExtra2", HomeScreen.KEY_2_AREA_CONVERSION);
            myIntent.putExtra("stringExtra3", activityTitle);
            myIntent.putExtra("intExtra", activityImage);
            myIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(myIntent);
        });

        buttonAngle.setOnClickListener(view -> {
            myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.angle_button);
            int activityImage = R.drawable.ic_angle_white;
            String[] spinnerItems = getResources().getStringArray(R.array.angle_block);
            myIntent.putExtra("stringExtra1", HomeScreen.KEY_1_ANGLE_CONVERSION);
            myIntent.putExtra("stringExtra2", HomeScreen.KEY_2_ANGLE_CONVERSION);
            myIntent.putExtra("stringExtra3", activityTitle);
            myIntent.putExtra("intExtra", activityImage);
            myIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(myIntent);
        });

        buttonSpeed.setOnClickListener(view -> {
            myIntent = new Intent(getActivity(), UnitsConversionScreen.class);
            String activityTitle = getResources().getString(R.string.speed_button);
            int activityImage = R.drawable.ic_speed_white;
            String[] spinnerItems = getResources().getStringArray(R.array.speed_block);
            myIntent.putExtra("stringExtra1", HomeScreen.KEY_1_SPEED_CONVERSION);
            myIntent.putExtra("stringExtra2", HomeScreen.KEY_2_SPEED_CONVERSION);
            myIntent.putExtra("stringExtra3", activityTitle);
            myIntent.putExtra("intExtra", activityImage);
            myIntent.putExtra("stringArrayExtra", spinnerItems);
            startActivity(myIntent);
        });

        return v;
    }
}
