package in.shpt.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.UiThread;
import android.util.Log;

import org.androidannotations.annotations.EReceiver;

/**
 * Created by poovarasanv on 14/9/16.
 */

@EReceiver
public class SocketReceiver  extends BroadcastReceiver{

    @UiThread
    public void result(String res)
    {
        Log.i("Operation", "result: " + res);
    }
    @Override
    public void onReceive(Context context, Intent intent) {

    }
}
