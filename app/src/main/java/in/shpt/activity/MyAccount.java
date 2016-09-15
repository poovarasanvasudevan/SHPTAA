package in.shpt.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import in.shpt.R;
import in.shpt.networking.ProductWorker;

@EActivity(R.layout.activity_my_account)
public class MyAccount extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

    @Bean
    ProductWorker productWorker;

    @AfterViews
    public void init() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        new MyAccountLoader().execute();
    }

    class MyAccountLoader extends AsyncTask<Void, Void, JSONObject> {
        @Override
        protected JSONObject doInBackground(Void... voids) {
            try {
                return productWorker.accountInfo();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(JSONObject response) {

            if (response != null) {

                getSupportActionBar().setTitle(response.optString("heading_title"));
                getSupportActionBar().setSubtitle(response.optString("text_your_details"));
            }
            super.onPostExecute(response);
        }
    }

    @Override
    public void onBackPressed() {
        HomeActivity_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).isNewLogin(true).start();
        finish();
        super.onBackPressed();
    }

    @OptionsItem(android.R.id.home)
    public void homeClicked() {
        HomeActivity_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).isNewLogin(true).start();
        finish();
    }
}
