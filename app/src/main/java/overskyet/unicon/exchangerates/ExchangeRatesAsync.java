package overskyet.unicon.exchangerates;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.jakewharton.threetenabp.AndroidThreeTen;

import org.json.JSONObject;
import org.threeten.bp.DateTimeUtils;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
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
import java.util.TimeZone;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import overskyet.unicon.HomeScreen;

public class ExchangeRatesAsync extends ViewModel {

    private SharedPreferences preferences;

    private static final String TAG = ExchangeRatesAsync.class.getSimpleName();
    private static final String ECB_URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";

    private void startAsyncTask() {
        new DownloadExchangeRatesTask().execute(ECB_URL);
    }

    private void setSharedPreferences(Map<String, Double> rates, String time) {
        if (preferences != null) {
            JSONObject jsonMapObject = new JSONObject(rates);
            String jsonMapString = jsonMapObject.toString();
            SharedPreferences.Editor editor = preferences.edit();
            editor.remove(HomeScreen.KEY_MAP_OF_RATES).apply();
            editor.remove(HomeScreen.KEY_ECB_TIME_OF_UPDATE).apply();
            editor.putString(HomeScreen.KEY_MAP_OF_RATES, jsonMapString);
            editor.putString(HomeScreen.KEY_ECB_TIME_OF_UPDATE, time);
            editor.apply();
        }

    }

    private void updateTime() {
        if (preferences != null) {
            LocalDateTime nextUpdateTime = LocalDate.now(ZoneId.of("Europe/Berlin")).plusDays(1).atTime(17, 0);
            long timeInSeconds = nextUpdateTime.toEpochSecond(ZoneId.of("Europe/Berlin").getRules().getOffset(nextUpdateTime));
            SharedPreferences.Editor editor = preferences.edit();
            editor.remove(HomeScreen.KEY_NEXT_UPDATE_TIME);
            editor.putLong(HomeScreen.KEY_NEXT_UPDATE_TIME, timeInSeconds);
            editor.apply();
        }
    }

    private class DownloadExchangeRatesTask extends AsyncTask<String, Void, ExchangeRates> {

        @Override
        protected ExchangeRates doInBackground(String... urls) {
            URL url = urls.length == 0 ? createUrl(ECB_URL) : createUrl(urls[0]);
            return url == null ? null : makeHttpRequest(url);
        }

        @Override
        protected void onPostExecute(ExchangeRates exchangeRates) {
            if (exchangeRates == null) return;

            setSharedPreferences(exchangeRates.getRates(), exchangeRates.getTime());
            updateTime();
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
                exchangeRates = parseXml(inputStream);
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

        private ExchangeRates parseXml(InputStream is) {

            List<String> currencies = new ArrayList<>();
            Map<String, Double> rates = new HashMap<>();
            String time = "";

            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(is);
                Element element = doc.getDocumentElement();
                element.normalize();
                Node RootNode = doc.getElementsByTagName("Cube").item(0);
                NodeList nList = RootNode.getChildNodes();
                Node node = nList.item(1);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    if (node.hasAttributes()) {
                        time = node.getAttributes().getNamedItem("time").getNodeValue();
                    }
                    NodeList childNodeList = node.getChildNodes();
                    for (int i = 0; i < childNodeList.getLength(); i++) {
                        if (childNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                            Node childNode = childNodeList.item(i);
                            String attributeCurrency = childNode.getAttributes().getNamedItem("currency").getNodeValue();
                            String attributeRate = childNode.getAttributes().getNamedItem("rate").getNodeValue();
                            currencies.add(attributeCurrency);
                            rates.put(attributeCurrency, Double.valueOf(attributeRate));
                        }
                    }
                }
            } catch (IOException | ParserConfigurationException | SAXException e) {
                Log.e(TAG, "parseXml: ", e);
                return null;
            }
            return new ExchangeRates(currencies, rates, time);
        }
    }

    public void checkScheduleForAsync(Context context) {
        preferences = context.getApplicationContext().getSharedPreferences(
                HomeScreen.KEY_NAME_OF_SHARED_PREFERENCES, Context.MODE_PRIVATE);

        AndroidThreeTen.init(context);

        LocalDateTime myCurrentDateInCETtimeZone = LocalDateTime.now(ZoneId.of("Europe/Berlin"));
        LocalDateTime defaultUpdateTime = LocalDate.now(ZoneId.of("Europe/Berlin")).atTime(17, 0);

        long updateTimeInSeconds = preferences.getLong(
                HomeScreen.KEY_NEXT_UPDATE_TIME, defaultUpdateTime.toEpochSecond(
                        ZoneId.of("Europe/Berlin").getRules().getOffset(defaultUpdateTime)));
        LocalDateTime nextUpdateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(updateTimeInSeconds),
                DateTimeUtils.toZoneId(TimeZone.getTimeZone("Europe/Berlin")));

        if (myCurrentDateInCETtimeZone.compareTo(nextUpdateTime) >= 0) startAsyncTask();
    }
}
