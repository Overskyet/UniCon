package overskyet.unicon.ui.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import overskyet.unicon.MyApplication;
import overskyet.unicon.R;

public class HomeScreenActivity extends AppCompatActivity {

    // TODO Runtime exception incoming?
    private static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
    }

    public static SharedPreferences getSharedPreferences() { return sharedPreferences; }
}
