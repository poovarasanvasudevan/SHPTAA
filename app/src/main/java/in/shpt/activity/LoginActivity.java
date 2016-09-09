package in.shpt.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import carbon.widget.Button;
import in.shpt.R;


@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {


    @ViewById
    Toolbar toolbar;

    @ViewById
    Button loginBtn;

    @AfterViews
    public void afterViews() {
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Click(R.id.loginBtn)
    public void loginBtnClicked(View v) {

        if(ParseUser.getCurrentUser() == null) {
            ParseUser.logInInBackground("poosan", "poosan", new LogInCallback() {
                public void done(ParseUser user, ParseException e) {
                    if (user != null) {


                        HomeActivity_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).start();
                        finish();
                    } else {
                        // Signup failed. Look at the ParseException to see what happened.
                    }
                }
            });
        } else {

            HomeActivity_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).start();
            finish();

        }

    }
}
