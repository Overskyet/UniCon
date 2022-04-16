package overskyet.unicon.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;


public final class CurrencyConverter {

    private CurrencyConverter() {
    }

    private static class CurrencyConverterHolder {
        private static final CurrencyConverter instance = new CurrencyConverter();
    }

    public static CurrencyConverter getInstance() {
        return CurrencyConverterHolder.instance;
    }

    private Map<String, Double> rates;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal amount;
    private int calculationAccuracy = 4;

    public BigDecimal convert(String fromCurrency, String toCurrency, BigDecimal amount, Map<String, Double> rates) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.rates = rates;
        return isRateEntryEuro() ? startConversionInEuro() : startConversion();
    }

    public BigDecimal convert(String fromCurrency, String toCurrency, BigDecimal amount, int calculationAccuracy, Map<String, Double> rates) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.rates = rates;
        this.calculationAccuracy = calculationAccuracy < 0 ? this.calculationAccuracy : calculationAccuracy;
        return isRateEntryEuro() ? startConversionInEuro() : startConversion();
    }

    private BigDecimal startConversion() {
        BigDecimal baseRate, targetRate;
        BigDecimal result = null;

        if (isRateEntryExist()) {
            baseRate = new BigDecimal(rates.get(fromCurrency).toString());
            targetRate = new BigDecimal(rates.get(toCurrency).toString());

            if (baseRate.compareTo(targetRate) < 0) {
                result = amount.multiply(targetRate).divide(baseRate, calculationAccuracy, RoundingMode.HALF_UP);
            } else if (baseRate.compareTo(targetRate) > 0) {
                result = amount.divide(baseRate, calculationAccuracy, RoundingMode.HALF_UP).multiply(targetRate).setScale(calculationAccuracy, RoundingMode.HALF_UP);
            }
        }
        return result;
    }

    private BigDecimal startConversionInEuro() {
        BigDecimal baseRate, targetRate;
        BigDecimal result = null;

        if (isOneOfRateEntriesExist()) {
            if (fromCurrency.equals("EUR") && !toCurrency.equals("EUR")) {
                targetRate = new BigDecimal(rates.get(toCurrency).toString());
                result = amount.multiply(targetRate).setScale(calculationAccuracy, RoundingMode.HALF_UP);
            } else if (toCurrency.equals("EUR") && !fromCurrency.equals("EUR")) {
                baseRate = new BigDecimal(rates.get(fromCurrency).toString());
                result = amount.divide(baseRate, calculationAccuracy, RoundingMode.HALF_UP);
            }
        }
        return result;
    }

    private boolean isRateEntryExist() {
        return (rates.containsKey(fromCurrency) && rates.containsKey(toCurrency));
    }

    private boolean isRateEntryEuro() {
        return (fromCurrency.equals("EUR") || toCurrency.equals("EUR"));
    }

    private boolean isOneOfRateEntriesExist() {
        return (rates.containsKey(fromCurrency) || rates.containsKey(toCurrency));
    }
}
