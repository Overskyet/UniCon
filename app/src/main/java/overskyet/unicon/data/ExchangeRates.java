package overskyet.unicon.data;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Map;

public class ExchangeRates {
    private final List<String> mCurrencies;
    private final Map<String, Double> mRates;
    private final String mTime;

    public ExchangeRates(List<String> currencies, Map<String, Double> rates, String time) {
        this.mCurrencies = currencies;
        this.mRates = rates;
        this.mTime = time;
    }

    public Map<String, Double> getRates() {
        return mRates;
    }

    public List<String> getCurrencies() {
        return mCurrencies;
    }

    public String getTime() {
        return mTime;
    }

    public Boolean isRatesEmpty() {
        return mCurrencies.isEmpty() || mRates.isEmpty() || mTime.isEmpty();
    }

    @Override
    @NonNull
    public String toString() {
        return "ExchangeRates{" +
                "mCurrencies=" + mCurrencies +
                ", mRates=" + mRates +
                ", mTime='" + mTime + '\'' +
                '}';
    }
}
