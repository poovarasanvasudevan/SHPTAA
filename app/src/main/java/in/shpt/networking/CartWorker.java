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
public class CartWorker {
    @RootContext
    Context context;

    @App
    SHPT shpt;

    public int getCartCount() throws JSONException, IOException {
        String response = shpt.getAdapter().cartCount().execute().body().string();
        Log.i("Cart", response);
        return new JSONObject(response).optInt("count");
    }

    public JSONObject addToCart(String product_id, int quantity) throws IOException, JSONException {
        String response = shpt.getAdapter().addToCart(product_id, quantity).execute().body().string();
        return new JSONObject(response);
    }


    public JSONObject getMyCart() throws IOException, JSONException {
        String response = shpt.getAdapter().getShoppingCart(true).execute().body().string();
        return new JSONObject(response);
    }

}
