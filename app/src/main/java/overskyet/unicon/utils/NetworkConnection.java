package overskyet.unicon.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

public final class NetworkConnection {
    public static boolean hasInternetConnection(Context context) {
        boolean result = false;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
            return false;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            NetworkCapabilities networkCapabilities = cm.getNetworkCapabilities(cm.getActiveNetwork());
            if (networkCapabilities != null) {
                result = networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                        || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                        || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET);
            }
        } else {
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if (networkInfo != null) {
                if (networkInfo.isConnectedOrConnecting()) {
                    switch (networkInfo.getType()) {
                        case ConnectivityManager.TYPE_WIFI:
                        case ConnectivityManager.TYPE_MOBILE:
                        case ConnectivityManager.TYPE_ETHERNET:
                            result = true;
                            break;
                        default:
                            result = false;
                            break;
                    }
                }
            }
        }
        return result;
    }
}
