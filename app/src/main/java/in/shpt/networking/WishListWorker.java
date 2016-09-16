package in.shpt.networking;

import android.content.Context;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import in.shpt.application.SHPT;

/**
 * Created by poovarasanv on 16/9/16.
 */

@EBean
public class WishListWorker {
    @RootContext
    Context context;

    @App
    SHPT shpt;


    public JSONObject addToWishList(String product_id) throws IOException, JSONException {
        return new JSONObject(shpt.getAdapter().addToWishList(product_id).execute().body().string());
    }

    public  JSONObject getWishList() throws IOException, JSONException {
        return new JSONObject(shpt.getAdapter().getWishList(true).execute().body().string());
    }

    public  JSONObject removeWishList(String product_id) throws IOException, JSONException {
        return new JSONObject(shpt.getAdapter().removeWishList(product_id).execute().body().string());
    }
}
