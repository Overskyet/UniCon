package overskyet.unicon.exchangerates;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import overskyet.unicon.HomeScreen;

public class CurrencyConverter {

    private static final String TAG = CurrencyConverter.class.getSimpleName();

    private Context mContext;

    private String mFromCurrency;
    private String mToCurrency;
    private BigDecimal mAmount;
    private int mCalculationAccuracy = 4;

    private BigDecimal mResult = new BigDecimal(0.0);

    public CurrencyConverter(Context context) {
        mContext = context;
    }

    public BigDecimal convert(String fromCurrency, String toCurrency, BigDecimal amount) {
        mFromCurrency = fromCurrency;
        mToCurrency = toCurrency;
        mAmount = amount;
        return startConversion();
    }

    public BigDecimal convert(String fromCurrency, String toCurrency, BigDecimal amount, int calculationAccuracy) {
        mFromCurrency = fromCurrency;
        mToCurrency = toCurrency;
        mAmount = amount;
        mCalculationAccuracy = calculationAccuracy < 0 ? mCalculationAccuracy : calculationAccuracy;
        return startConversion();
    }

    private BigDecimal startConversion() {
        Map<String, Double> rates = getRates();
        BigDecimal baseRate, targetRate;
        if (rates != null) {
            if (rates.containsKey(mFromCurrency) && rates.containsKey(mToCurrency)) {
                baseRate = new BigDecimal(rates.get(mFromCurrency));
                targetRate = new BigDecimal(rates.get(mToCurrency));
                if (baseRate.compareTo(targetRate) < 0) {
                    mResult = mAmount.multiply(targetRate).divide(baseRate, mCalculationAccuracy, RoundingMode.HALF_UP);
                } else if (baseRate.compareTo(targetRate) > 0) {
                    mResult = mAmount.divide(baseRate, mCalculationAccuracy, RoundingMode.HALF_UP).multiply(targetRate).setScale(mCalculationAccuracy, RoundingMode.HALF_UP);
                } else {
                    mResult = mAmount;
                }
            } else {
                if (mFromCurrency.equals("EUR") && !mToCurrency.equals("EUR")) {
                    targetRate = new BigDecimal(rates.get(mToCurrency));
                    mResult = mAmount.multiply(targetRate).setScale(mCalculationAccuracy, RoundingMode.HALF_UP);
                } else if (mToCurrency.equals("EUR") && !mFromCurrency.equals("EUR")) {
                    baseRate = new BigDecimal(rates.get(mFromCurrency));
                    mResult = mAmount.divide(baseRate, mCalculationAccuracy, RoundingMode.HALF_UP);
                } else {
                    mResult = mAmount;
                }
            }
        }
        return mResult;
    }

    private Map<String, Double> getRates() {
        Map<String, Double> rates = new HashMap<>();
        SharedPreferences preferences = mContext.getApplicationContext().getSharedPreferences(HomeScreen.KEY_NAME_OF_SHARED_PREFERENCES,
                Context.MODE_PRIVATE);
        if (preferences != null) {
            try {
                String jsonString = preferences.getString(HomeScreen.KEY_MAP_OF_RATES, new JSONObject().toString());
                JSONObject jsonObject = new JSONObject(jsonString);
                Iterator<String> keyItr = jsonObject.keys();
                while (keyItr.hasNext()) {
                    String key = keyItr.next();
                    rates.put(key, jsonObject.getDouble(key));
                }
            } catch (JSONException e) {
                Log.e(TAG, "getRates: ", e);
                return null;
            }
        }
        return rates;
    }
}
