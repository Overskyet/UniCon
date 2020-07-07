package overskyet.unicon.ui.fragments.currency;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import overskyet.unicon.data.ExchangeRates;
import overskyet.unicon.data.ExchangeRatesAsync;
import overskyet.unicon.data.ExchangeRatesXmlParser;

public final class CurrencyExchangeViewModel extends ViewModel {

    private static final String TAG = CurrencyExchangeViewModel.class.getSimpleName();

    private static final String ECB_URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";

    private boolean isNotInitialized = true;

    public ExchangeRates rates

    public void initUi() {
        if (isNotInitialized) {
            startAsyncTask();
        }
    }

    private void startAsyncTask() {
        new CurrencyExchangeViewModel.DownloadExchangeRatesTask().execute(ECB_URL);
    }

    private class DownloadExchangeRatesTask extends AsyncTask<String, Void, ExchangeRates> {

        @Override
        protected ExchangeRates doInBackground(String... urls) {
            URL url = urls.length == 0 ? createUrl(ECB_URL) : createUrl(urls[0]);
            return url == null ? null : makeHttpRequest(url);
        }

        @Override
        protected void onPostExecute(ExchangeRates exchangeRates) {
            if (exchangeRates == null || exchangeRates.isEmpty()) return;

            isNotInitialized = false;
        }

        private URL createUrl(String strUrl) {
            URL url = null;
            try {
                url = new URL(strUrl);
            } catch (MalformedURLException e) {
                Log.e(TAG, "createUrl: ", e);
            }
            return url;
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
}
