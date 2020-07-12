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
}
