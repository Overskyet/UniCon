package overskyet.unicon.data.network;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import overskyet.unicon.data.ExchangeRates;
import overskyet.unicon.data.ExchangeRatesXmlParser;

public final class ExchangeRatesHttpRequest {

    private static final String TAG = ExchangeRatesHttpRequest.class.getSimpleName();

    private static class ExchangeRatesHttpRequestHolder {
        private final static ExchangeRatesHttpRequest instance = new ExchangeRatesHttpRequest();
    }

    public static ExchangeRatesHttpRequest getInstance() {
        return ExchangeRatesHttpRequestHolder.instance;
    }

    private ExchangeRatesHttpRequest() {}

    public ExchangeRates loadData(URL url) {
        return makeHttpRequest(url);
    }

    private ExchangeRates makeHttpRequest(URL url) {
        ExchangeRates exchangeRates = null;
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.connect();
            if (urlConnection.getResponseCode() != 200) {
                Log.e(TAG, "makeHttpRequest: response code is " + urlConnection.getResponseCode());
                urlConnection.disconnect();
                return null;
            }
            inputStream = urlConnection.getInputStream();
            exchangeRates = ExchangeRatesXmlParser.getInstance().parseXml(inputStream);
        } catch (IOException e) {
            Log.e(TAG, "makeHttpRequest: ", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.e(TAG, "makeHttpRequest: inputStream.close()", e);
                }
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return exchangeRates;
    }
}
