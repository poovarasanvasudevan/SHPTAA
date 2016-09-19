package in.shpt.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import carbon.widget.TextView;
import in.shpt.R;
import in.shpt.adapter.CartAdapter;
import in.shpt.event.CartEvent;
import in.shpt.networking.CartWorker;
import in.shpt.shptenum.AlertMakerEnum;
import in.shpt.ui.AlertMaker;

@EActivity(R.layout.activity_shopping_cart)
public class ShoppingCartActivity extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

    @Bean
    CartWorker cartWorker;

    @ViewById()
    TextView cImage, cName, cQty, cAmount, totalText;

    @Bean
    CartAdapter cartAdapter;

    @ViewById
    RecyclerView orderListLoader;

    @ViewById
    AlertMaker alertMaker;

    @Override
    protected void onStart() {
        EventBus.getDefault().register(this);
        super.onStart();
    }

    @AfterViews
    public void init() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        orderListLoader.setLayoutManager(llm);

        new ShoppingCartTask().execute();
    }

    class ShoppingCartTask extends AsyncTask<Void, Void, JSONObject> {
        @Override
        protected JSONObject doInBackground(Void... voids) {
            try {
                return cartWorker.getMyCart();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            if (jsonObject != null) {
                String totalTxt = "";
                getSupportActionBar().setTitle(jsonObject.optString("heading_title"));

                cImage.setText(jsonObject.optString("column_image"));
                cName.setText(jsonObject.optString("column_name"));
                cQty.setText(jsonObject.optString("column_quantity"));
                cAmount.setText(jsonObject.optString("column_total"));


                List<JSONObject> allJson = new ArrayList<>();

                if (jsonObject.optJSONArray("products").length() > 0) {

                    for (int i = 0; i < jsonObject.optJSONArray("products").length(); i++) {
                        allJson.add(jsonObject.optJSONArray("products").optJSONObject(i));
                    }

                    cartAdapter.addData(allJson);
                    orderListLoader.setAdapter(cartAdapter);
                } else {

                }

                List<JSONObject> total = new ArrayList<>();

                if (jsonObject.optJSONArray("totals").length() > 0) {

                    for (int i = 0; i < jsonObject.optJSONArray("totals").length(); i++) {
                        if (jsonObject.optJSONArray("totals").optJSONObject(i).optString("code").equals("total")) {
                            totalTxt = jsonObject.optJSONArray("totals").optJSONObject(i).optString("title") + " : " + jsonObject.optJSONArray("totals").optJSONObject(i).optString("text");
                        }
                    }

                } else {

                }

                totalText.setText(totalTxt);


            }


            super.onPostExecute(jsonObject);
        }
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(CartEvent event) {
        if (event.getMessage().equals("refresh")) {
            cartAdapter.clearData();
            new ShoppingCartTask().execute();

            alertMaker.makeAlert("Item Removed from Cart", AlertMakerEnum.WARNING);
        }
    }

    @OptionsItem(android.R.id.home)
    public void homeClicked() {
        finish();
    }
}
