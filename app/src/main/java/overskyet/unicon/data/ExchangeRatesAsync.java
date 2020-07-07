//package overskyet.unicon.data;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import androidx.lifecycle.ViewModel;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//
//import overskyet.unicon.ui.HomeScreenActivity;
//import overskyet.unicon.MyApplication;
//
//public class ExchangeRatesAsync extends ViewModel {
//
//    private void setSharedPreferences(Map<String, Double> rates, String time) {
//        SharedPreferences preferences = MyApplication.getContext().getSharedPreferences(HomeScreenActivity.KEY_EXCHANGE_RATES_SHARED_PREFERENCES, Context.MODE_PRIVATE);
//        if (preferences != null) {
//            String sharedPrefTime = preferences.getString(HomeScreenActivity.KEY_ECB_TIME_OF_UPDATE, time);
//            if (sharedPrefTime.equalsIgnoreCase(time)) return;
//            Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
//            String jsonMapString = gson.toJson(rates);
//            preferences.edit()
//                    .remove(HomeScreenActivity.KEY_MAP_OF_RATES)
//                    .remove(HomeScreenActivity.KEY_ECB_TIME_OF_UPDATE)
//                    .putString(HomeScreenActivity.KEY_MAP_OF_RATES, jsonMapString)
//                    .putString(HomeScreenActivity.KEY_ECB_TIME_OF_UPDATE, time)
//                    .apply();
//        }
//    }
//}
