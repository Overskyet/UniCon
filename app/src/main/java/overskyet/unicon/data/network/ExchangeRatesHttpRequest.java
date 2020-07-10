package overskyet.unicon.data.network;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import overskyet.unicon.data.parser.ParseType;
import overskyet.unicon.data.parser.Parser;
import overskyet.unicon.data.parser.ParserFactoryImpl;
import overskyet.unicon.data.pojo.ExchangeRates;
import overskyet.unicon.data.parser.ExchangeRatesXmlParser;

public final class ExchangeRatesHttpRequest {

    private static final String TAG = ExchangeRatesHttpRequest.class.getSimpleName();

    private static class ExchangeRatesHttpRequestHolder {
        private final static ExchangeRatesHttpRequest instance = new ExchangeRatesHttpRequest();
    }

    public static ExchangeRatesHttpRequest getInstance() {
        return ExchangeRatesHttpRequestHolder.instance;
    }

    private ExchangeRatesHttpRequest() { }

    public ExchangeRates loadData(URL url, ParseType type) {
        return makeHttpRequest(url, type);
    }

    private ExchangeRates makeHttpRequest(URL url, ParseType type) {
        Parser parser = ParserFactoryImpl.getInstance().createParser(type);
        if (parser == null) return null;
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
            exchangeRates = parser.parse(inputStream);
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
