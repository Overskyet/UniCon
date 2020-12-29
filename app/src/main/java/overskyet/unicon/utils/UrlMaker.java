package overskyet.unicon.utils;

import android.util.Log;

import androidx.annotation.Nullable;

import java.net.MalformedURLException;
import java.net.URL;

public final class UrlMaker {
    @Nullable
    public static URL createUrl(String strUrl) {
        URL url = null;
        try {
            url = new URL(strUrl);
        } catch (MalformedURLException e) {
            Log.e(UrlMaker.class.getSimpleName(), "Can't create url. ", e);
        }
        return url;
    }
}
