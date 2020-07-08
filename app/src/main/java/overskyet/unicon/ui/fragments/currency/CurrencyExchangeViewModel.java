package overskyet.unicon.ui.fragments.currency;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.net.URL;

import overskyet.unicon.data.ExchangeRates;
import overskyet.unicon.data.network.ExchangeRatesHttpRequest;
import overskyet.unicon.utils.UrlMaker;

public final class CurrencyExchangeViewModel extends ViewModel {

    private static final String TAG = CurrencyExchangeViewModel.class.getSimpleName();

    private static final String ECB_URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";

    private boolean isNotInitialized = true;

    private MutableLiveData<ExchangeRates> rates = new MutableLiveData<>();

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
        new AsyncTask<Void, Void, ExchangeRates>() {
            @Override
            protected ExchangeRates doInBackground(Void... voids) {
                URL requestUrl = UrlMaker.createUrl(url);
                return requestUrl == null ? null : ExchangeRatesHttpRequest.getInstance().loadData(requestUrl);
            }

            @Override
            protected void onPostExecute(ExchangeRates exchangeRates) {
                if (exchangeRates == null || exchangeRates.isEmpty()) return;

                isNotInitialized = false;
                rates.setValue(exchangeRates);
            }
        }.execute();
    }
}
