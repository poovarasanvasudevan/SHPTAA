package in.shpt.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.UiThread;
import android.util.Log;

import org.androidannotations.annotations.EReceiver;
import org.json.JSONObject;

import khirr.parselivequery.BaseQuery;
import khirr.parselivequery.LiveQueryClient;
import khirr.parselivequery.Subscription;
import khirr.parselivequery.interfaces.OnListener;

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
        LiveQueryClient.connect();

        LiveQueryClient.on(LiveQueryClient.CONNECTED, new OnListener() {
            @Override
            public void on(final JSONObject object) {
                //  Subscribe to any event if you need as soon as connect to server
               result(object.toString());

            }
        });

        LiveQueryClient.on(LiveQueryClient.SUBSCRIBED, new OnListener() {
            @Override
            public void on(final JSONObject object) {
                result(object.toString());
            }
        });

        //  Subscription
        final Subscription subscription = new BaseQuery.Builder("Comments")
                .build()
                .subscribe();

        //  Listen
        subscription.on(Subscription.CREATE, new OnListener() {
            @Override
            public void on(final JSONObject object) {
                Log.e("CREATE", object.toString());
                result(object.toString());
            }
        });

        //  Listen ALL events
        subscription.on(Subscription.ALL, new OnListener() {
            @Override
            public void on(final JSONObject object) {
                result(object.toString());
            }
        });
    }
}
