package in.shpt.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;
import org.json.JSONObject;

import in.shpt.R;

@EActivity(R.layout.activity_shopping_cart)
public class ShoppingCartActivity extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

    @AfterViews
    public void init() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    class ShoppingCartTask extends AsyncTask<Void,Void,JSONObject> {
        @Override
        protected JSONObject doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            super.onPostExecute(jsonObject);
        }
    }



    @OptionsItem(android.R.id.home)
    public void homeClicked() {
        finish();
    }
}
