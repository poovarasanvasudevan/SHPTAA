package in.shpt.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.androidannotations.annotations.EReceiver;
import org.androidannotations.annotations.sharedpreferences.Pref;
import org.greenrobot.eventbus.EventBus;

import in.shpt.preference.SHPTPreferences_;

/**
 * Created by poovarasanv on 4/8/16.
 */

@EReceiver
public class ConnectionWatcher extends BroadcastReceiver {
    private boolean isConnected = false;

    @Pref
    SHPTPreferences_ shptPreferences;

    @Override
    public void onReceive(Context context, Intent intent) {

        shptPreferences.isInternetAvailable().put(isNetworkAvailable(context));

        if (isNetworkAvailable(context)) {
            EventBus.getDefault().post(true);
            shptPreferences.isInternetAvailable().put(true);
        } else {
            EventBus.getDefault().post(false);
            shptPreferences.isInternetAvailable().put(false);
        }
    }

    private boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        if (!isConnected) {
                            isConnected = true;
                        }
                        return true;
                    }
                }
            }
        }
        isConnected = false;
        return false;
    }
}
