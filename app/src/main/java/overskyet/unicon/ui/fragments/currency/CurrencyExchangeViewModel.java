package overskyet.unicon.ui.fragments.currency;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import overskyet.unicon.data.parser.ParseType;
import overskyet.unicon.data.pojo.ExchangeRates;
import overskyet.unicon.data.network.ExchangeRatesHttpRequest;
import overskyet.unicon.utils.UrlMaker;

public final class CurrencyExchangeViewModel extends ViewModel {

    private static final String TAG = CurrencyExchangeViewModel.class.getSimpleName();

    private static final String ECB_URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";

    private boolean isNotInitialized = true;

    private MutableLiveData<Map<String, Double>> mapOfRates = new MutableLiveData<>();
    private MutableLiveData<String> lastUpdateTime = new MutableLiveData<>();

    public void initUi() {
        if (isNotInitialized) {
            startAsyncTask();
        }
    }

    MutableLiveData<Map<String, Double>> getMapOfRates() { return mapOfRates; }
    MutableLiveData<String> getLastUpdateTime() { return lastUpdateTime; }

    private void startAsyncTask() {
        loadRates(ECB_URL);
    }

    @SuppressLint("StaticFieldLeak")
    private void loadRates(String url) {
        new AsyncTask<Void, Void, ExchangeRates>() {
            @Override
            protected ExchangeRates doInBackground(Void... voids) {
                URL urlRequest = UrlMaker.createUrl(url);
                return urlRequest == null ? null : ExchangeRatesHttpRequest.getInstance().loadData(urlRequest, ParseType.XML);
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
