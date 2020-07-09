package overskyet.unicon.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

public final class MapSerializationAndDeserialization {
    public static Map<String, Double> deserializeMap(String stringMap) {
        return new Gson().fromJson(stringMap, new TypeToken<Map<String, Double>>() {}.getType());
    }

    public static String serializeMap(Map<String, Double> map) {
        return new GsonBuilder().enableComplexMapKeySerialization().create().toJson(map);
    }

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
}
