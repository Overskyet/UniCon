package overskyet.unicon.exchangerates;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
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

import overskyet.unicon.HomeScreen;

public class ExchangeRatesAsync {

    private Context mContext;

    public ExchangeRatesAsync(Context context) {
        mContext = context;
    }

    private static final String TAG = ExchangeRatesAsync.class.getSimpleName();
    private static final String ECB_URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";

    private void startAsyncTask() {
        new DownloadExchangeRatesTask().execute(ECB_URL);
    }

    private void setSharedPreferences(List<String> currencies, Map<String, Double> rates, String time) {
        SharedPreferences preferences = mContext.getApplicationContext().getSharedPreferences(HomeScreen.KEY_NAME_OF_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        if (preferences != null) {
            JSONObject jsonMapObject = new JSONObject(rates);
            JSONArray jsonListArray = new JSONArray(currencies);
            String jsonMapString = jsonMapObject.toString();
            String jsonListString = jsonListArray.toString();
            SharedPreferences.Editor editor = preferences.edit();
            editor.remove(HomeScreen.KEY_MAP_OF_RATES).apply();
            editor.remove(HomeScreen.KEY_LIST_OF_CURRENCIES).apply();
            editor.remove(HomeScreen.KEY_TIME_OF_UPDATE).apply();
            editor.putString(HomeScreen.KEY_MAP_OF_RATES, jsonMapString);
            editor.putString(HomeScreen.KEY_LIST_OF_CURRENCIES, jsonListString);
            editor.putString(HomeScreen.KEY_TIME_OF_UPDATE, time);
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

            // Init mCurrencies after background task is complete
            // TODO Handle spinner adapter clear, add new data, and refresh
            setSharedPreferences(exchangeRates.getCurrencies(), exchangeRates.getRates(), exchangeRates.getTime());
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

        // TODO Need to set up scheduler for rates updates
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

    //TODO Create static method to check whether the data is old or not and to start asynctask
    public void checkScheduleForAsync() {
        startAsyncTask();
    }
    /*
    public void setDate(Context context) {
        AndroidThreeTen.init(context);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");

        LocalDateTime myCurrentDateInCETtimeZone = LocalDateTime.now(ZoneId.of("Europe/Berlin"));
        String e = formatter.format(myCurrentDateInCETtimeZone);
        Log.i(TAG, "setDate: " + e);
    }
    */
}
