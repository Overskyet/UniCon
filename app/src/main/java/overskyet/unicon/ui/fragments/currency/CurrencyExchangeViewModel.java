package overskyet.unicon.ui.fragments.currency;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.net.URL;
import java.util.Map;

import overskyet.unicon.data.network.BadResponseCodeException;
import overskyet.unicon.data.parser.ParseType;
import overskyet.unicon.data.pojo.ExchangeRates;
import overskyet.unicon.data.network.ExchangeRatesHttpRequest;
import overskyet.unicon.utils.UrlMaker;

public final class CurrencyExchangeViewModel extends ViewModel {

    private static final String TAG = CurrencyExchangeViewModel.class.getSimpleName();

    private static final String ECB_URL = "https://www.ecb.europa.eu/stats/eurofxref/euroxref-daily.xml";

    private boolean isNotInitialized = true;

    private MutableLiveData<Map<String, Double>> mapOfRates = new MutableLiveData<>();
    private MutableLiveData<String> lastUpdateTime = new MutableLiveData<>();

    public void initUi() {
        if (isNotInitialized) {
            startAsyncTask();
        }
    }

    public void setNotInitialized(boolean flag) {
        this.isNotInitialized = flag;
    }

    MutableLiveData<Map<String, Double>> getMapOfRates() {
        return mapOfRates;
    }

    MutableLiveData<String> getLastUpdateTime() {
        return lastUpdateTime;
    }

    private void startAsyncTask() {
        loadRates(ECB_URL);
    }

    @SuppressLint("StaticFieldLeak")
    private void loadRates(String url) {
        new AsyncTask<Void, Void, ExchangeRates>() {
            @Override
            protected ExchangeRates doInBackground(Void... voids) {
                URL urlRequest = UrlMaker.createUrl(url);
                if (urlRequest == null) return null;

                ExchangeRates rates = null;
                try {
                    rates = ExchangeRatesHttpRequest.getInstance().loadData(urlRequest, ParseType.XML);
                } catch (BadResponseCodeException e) {
                    Log.e(TAG, "doInBackground: ", e);
                }
                return rates;
            }

            // TODO Add loading animation
            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(ExchangeRates exchangeRates) {
                if (exchangeRates == null) return;

                isNotInitialized = false;
                mapOfRates.setValue(exchangeRates.getRates());
                lastUpdateTime.setValue(exchangeRates.getTime());
            }
        }.execute();
    }
}
