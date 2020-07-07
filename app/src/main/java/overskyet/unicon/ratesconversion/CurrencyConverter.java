package overskyet.unicon.ratesconversion;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import overskyet.unicon.ui.HomeScreenActivity;
import overskyet.unicon.MyApplication;

// TODO Make singleton and pass app context to constructor
public class CurrencyConverter {

    private String fromCurrency;
    private String toCurrency;
    private BigDecimal amount;
    private int calculationAccuracy = 4;

    private BigDecimal result = new BigDecimal("0.0");

    public BigDecimal convert(String fromCurrency, String toCurrency, BigDecimal amount) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        return startConversion();
    }

    public BigDecimal convert(String fromCurrency, String toCurrency, BigDecimal amount, int calculationAccuracy) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.calculationAccuracy = calculationAccuracy < 0 ? this.calculationAccuracy : calculationAccuracy;
        return startConversion();
    }

    private BigDecimal startConversion() {
        Map<String, Double> rates = getRates();
        BigDecimal baseRate, targetRate;
        if (rates != null) {
            if (rates.containsKey(fromCurrency) && rates.containsKey(toCurrency)) {
                baseRate = new BigDecimal(rates.get(fromCurrency).toString());
                targetRate = new BigDecimal(rates.get(toCurrency).toString());
                if (baseRate.compareTo(targetRate) < 0) {
                    result = amount.multiply(targetRate).divide(baseRate, calculationAccuracy, RoundingMode.HALF_UP);
                } else if (baseRate.compareTo(targetRate) > 0) {
                    result = amount.divide(baseRate, calculationAccuracy, RoundingMode.HALF_UP).multiply(targetRate).setScale(calculationAccuracy, RoundingMode.HALF_UP);
                } else {
                    result = amount;
                }
            } else {
                if (fromCurrency.equals("EUR") && !toCurrency.equals("EUR")) {
                    targetRate = new BigDecimal(rates.get(toCurrency).toString());
                    result = amount.multiply(targetRate).setScale(calculationAccuracy, RoundingMode.HALF_UP);
                } else if (toCurrency.equals("EUR") && !fromCurrency.equals("EUR")) {
                    baseRate = new BigDecimal(rates.get(fromCurrency).toString());
                    result = amount.divide(baseRate, calculationAccuracy, RoundingMode.HALF_UP);
                } else {
                    result = amount;
                }
            }
        }
        return result;
    }

    private Map<String, Double> getRates() {
        // TODO Delete context
        Context context = MyApplication.getContext();
        Map<String, Double> rates = null;
        // TODO Delete shared preferences, pass map of rates as constructor argument
        SharedPreferences preferences = context.getSharedPreferences(HomeScreenActivity.KEY_EXCHANGE_RATES_SHARED_PREFERENCES,
                Context.MODE_PRIVATE);
        if (preferences != null) {
            String jsonString = preferences.getString(HomeScreenActivity.KEY_MAP_OF_RATES, new JSONObject().toString());
            Type typeOfHashMap = new TypeToken<Map<String, Double>>() {}.getType();
            rates = new Gson().fromJson(jsonString, typeOfHashMap);
        }
        return rates;
    }
}
