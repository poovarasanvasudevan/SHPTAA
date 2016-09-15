package in.shpt.networking;

import android.content.Context;
import android.util.Log;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import in.shpt.application.SHPT;

/**
 * Created by poovarasanv on 15/9/16.
 */

@EBean
public class UserWorker {
    @RootContext
    Context context;

    @App
    SHPT shpt;


    public JSONObject getUser() throws IOException, JSONException {
        String response = shpt.getAdapter().getUserDetails().execute().body().string();
        return new JSONObject(response);
    }

    public JSONObject getUserSession() throws IOException, JSONException {
        String response = shpt.getAdapter().getUserSession().execute().body().string();
        return new JSONObject(response);
    }

    public JSONObject loginMe(String email) throws IOException, JSONException {
        String response = shpt.getAdapter().loginMe(email).execute().body().string();
        Log.i("ResponseDATA",response);
        return new JSONObject(response);
    }


    public JSONObject accountInfo() throws IOException, JSONException {
        String response = shpt.getAdapter().accountInfo(true).execute().body().string();
        Log.i("AccountInfo",response);
        return new JSONObject(response);
    }
}
