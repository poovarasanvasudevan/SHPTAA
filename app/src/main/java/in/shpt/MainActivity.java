package in.shpt;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import in.shpt.activity.LoginActivity_;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {




    @AfterViews
    public void init() {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                LoginActivity_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).start().withAnimation(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        }, 2000);
    }
}
