package overskyet.unicon.exchangerates;

import java.util.List;
import java.util.Map;

class ExchangeRates {
    private List<String> mCurrencies;
    private Map<String, Double> mRates;
    private String mTime;

    ExchangeRates(List<String> currencies, Map<String, Double> rates, String time) {
        this.mCurrencies = currencies;
        this.mRates = rates;
        this.mTime = time;
    }

    Map<String, Double> getRates() {
        return mRates;
    }

    List<String> getCurrencies() {
        return mCurrencies;
    }

    String getTime() {
        return mTime;
    }

    @Override
    public String toString() {
        return "ExchangeRates{" +
                "mCurrencies=" + mCurrencies +
                ", mRates=" + mRates +
                ", mTime='" + mTime + '\'' +
                '}';
    }
}
