package in.shpt.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

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
import in.shpt.adapter.WishListAdapter;
import in.shpt.event.CartEvent;
import in.shpt.event.WishListEvent;
import in.shpt.networking.WishListWorker;
import in.shpt.shptenum.AlertMakerEnum;
import in.shpt.ui.AlertMaker;

@EActivity(R.layout.activity_wish_list)
public class WishListActivity extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

    @ViewById
    RecyclerView wishListLoader;


    @ViewById
    TextView empty;

    @ViewById
    AlertMaker alertMaker;

    @Bean
    WishListAdapter wishListAdapter;

    @Bean
    WishListWorker wishListWorker;

    @Override
    protected void onStart() {
        EventBus.getDefault().register(this);
        super.onStart();
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @AfterViews
    public void init() {


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        wishListLoader.setLayoutManager(llm);


        new WishListLoader().execute();

    }

    class WishListLoader extends AsyncTask<Void, Void, JSONObject> {
        @Override
        protected JSONObject doInBackground(Void... voids) {
            try {
                return wishListWorker.getWishList();
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
                getSupportActionBar().setTitle(jsonObject.optString("heading_title"));
                List<JSONObject> allJson = new ArrayList<>();

                if (jsonObject.optJSONArray("products").length() > 0) {

                    for (int i = 0; i < jsonObject.optJSONArray("products").length(); i++) {
                        allJson.add(jsonObject.optJSONArray("products").optJSONObject(i));
                    }

                    wishListAdapter.addData(allJson);
                    wishListLoader.setAdapter(wishListAdapter);
                } else {
                    empty.setVisibility(View.VISIBLE);
                    empty.setText(jsonObject.optString("text_empty"));
                }
            }
            super.onPostExecute(jsonObject);
        }
    }

    @OptionsItem(android.R.id.home)
    public void homeClicked() {
        finish();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(CartEvent event) {
        alertMaker.makeAlert(event.getMessage(), AlertMakerEnum.SUCCESS);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(WishListEvent event) {
        if (event.getMessage().equals("refresh")) {
            wishListAdapter.clearData();
            new WishListLoader().execute();

            alertMaker.makeAlert("Item Removed from Wishlist", AlertMakerEnum.WARNING);
        }
    }

}
