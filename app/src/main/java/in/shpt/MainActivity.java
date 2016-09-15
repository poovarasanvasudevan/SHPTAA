package in.shpt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import in.shpt.activity.LoginWebView_;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @AfterViews
    public void init() {

        ParseQuery<ParseObject> query = ParseQuery.getQuery("User").whereExists("email");
        query.fromLocalDatastore();
        query.getFirstInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {

                LoginWebView_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).start().withAnimation(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        });
    }
}
