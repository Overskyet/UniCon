package overskyet.unicon.ui.fragments.currency;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import overskyet.unicon.data.ExchangeRates;
import overskyet.unicon.data.ExchangeRatesXmlParser;

public final class CurrencyExchangeViewModel extends ViewModel {

    private static final String TAG = CurrencyExchangeViewModel.class.getSimpleName();

    private static final String ECB_URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";

    private boolean isNotInitialized = true;

    private LiveData<ExchangeRates> rates = new MutableLiveData<>();

    public void initUi() {
        if (isNotInitialized) {
            startAsyncTask();
        }
    }

    public LiveData<ExchangeRates> getRates() {
        return rates;
    }

    private void startAsyncTask() {
        loadRates(ECB_URL);
    }

    @SuppressLint("StaticFieldLeak")
    private void loadRates(String url) {
        new AsyncTask<String, Void, ExchangeRates>() {
            @Override
            protected ExchangeRates doInBackground(String... urls) {
                return null;
            }

            @Override
            protected void onPostExecute(ExchangeRates exchangeRates) {
                super.onPostExecute(exchangeRates);
            }
        }.execute();
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
