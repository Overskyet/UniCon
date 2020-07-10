package overskyet.unicon.data.pojo;

import java.util.List;
import java.util.Map;

public final class ExchangeRates {

    private final List<String> currencies;
    private final Map<String, Double> rates;
    private final String time;

    public ExchangeRates(List<String> currencies, Map<String, Double> rates, String time) {
        this.currencies = currencies;
        this.rates = rates;
        this.time = time;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public List<String> getCurrencies() {
        return currencies;
    }

    public String getTime() {
        return time;
    }

}
