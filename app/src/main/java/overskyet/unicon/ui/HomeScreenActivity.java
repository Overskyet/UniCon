package overskyet.unicon.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import overskyet.unicon.R;
import overskyet.unicon.data.ExchangeRatesAsync;

public class HomeScreenActivity extends AppCompatActivity {

    public static final String KEY_MAP_OF_RATES = "overskyet.unicon.MAP_OF_RATES";
    public static final String KEY_ECB_TIME_OF_UPDATE = "overskyet.unicon.TIME_OF_UPDATE";
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //Start Scheduler here
        startAsync();

    }

    //TODO Move http request invoke to @CurrencyExchangeFragment
    private void startAsync() {
        final ExchangeRatesAsync exchangeRatesAsync = new ExchangeRatesAsync();
        exchangeRatesAsync.startAsyncTask();
        }
}
