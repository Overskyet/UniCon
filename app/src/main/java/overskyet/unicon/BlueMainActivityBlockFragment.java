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
public class BlueMainActivityBlockFragment extends Fragment {

    private Intent myIntent;

    public BlueMainActivityBlockFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blue_main_activity_block, container, false);

        Button buttonLength = v.findViewById(R.id.button_length);
        Button buttonWeight = v.findViewById(R.id.button_weight);
        Button buttonVolume = v.findViewById(R.id.button_volume);
        Button buttonArea = v.findViewById(R.id.button_area);
        Button buttonAngle = v.findViewById(R.id.button_angle);
        Button buttonSpeed = v.findViewById(R.id.button_speed);

        buttonLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), ConversionActivity.class);
                startActivity(myIntent);
            }
        });

        buttonWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), ConversionActivity.class);
                startActivity(myIntent);
            }
        });

        buttonVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), ConversionActivity.class);
                startActivity(myIntent);
            }
        });

        buttonArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), ConversionActivity.class);
                startActivity(myIntent);
            }
        });

        buttonAngle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), ConversionActivity.class);
                startActivity(myIntent);
            }
        });

        buttonSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent = new Intent(getActivity(), ConversionActivity.class);
                startActivity(myIntent);
            }
        });

        return v;
    }

}
