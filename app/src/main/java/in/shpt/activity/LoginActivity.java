package in.shpt.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import carbon.widget.Button;
import in.shpt.R;
import in.shpt.ui.SHPTToast_;


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
        SHPTToast_.success(this,"Hello World");
    }
}
