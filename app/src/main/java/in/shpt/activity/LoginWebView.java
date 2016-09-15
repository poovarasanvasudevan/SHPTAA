package in.shpt.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.pixplicity.easyprefs.library.Prefs;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

import in.shpt.R;
import in.shpt.config.Config;
import in.shpt.networking.UserWorker;
import in.shpt.preference.SHPTPreferences_;

@EActivity(R.layout.activity_login_web_view)
public class LoginWebView extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

    @ViewById
    WebView loginWeb;


    String code = "";
    String email = "";

    @Bean
    UserWorker productWorker;

    @Pref
    SHPTPreferences_ shptPreferences_;

    @AfterViews
    public void init() {

        setSupportActionBar(toolbar);
        loginWeb.setWebChromeClient(new WebChromeClient());
        loginWeb.setWebViewClient(new LoginWebViewClient());
        loginWeb.getSettings().setJavaScriptEnabled(true);
        loginWeb.addJavascriptInterface(new MyJavaScriptInterface(), "HTMLOUT");
        loginWeb.loadUrl(Config.LOGIN_URL);
    }

    class LoginWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            Log.i("Page Loading", url);

            if (url.startsWith(Config.LOGIN_BASE_URL) && !url.contains("shpt/mysrcm/callback")) {

                view.loadUrl(Config.BASE_URL + "index.php?route=api/product/user");

                //new GONext().execute(view.get);

            }
            if (url.contains("api/product/user")) {
                String cookies = CookieManager.getInstance().getCookie(url);

                Log.i("Cookies", cookies);
                String[] temp = cookies.split(";");

                for (String ar1 : temp) {
                    if (ar1.contains("PHPSESSID")) {
                        String[] temp1 = ar1.split("=");
                        String cookieValue = temp1[1];

                        Prefs.putString(Config.COOKIE, cookieValue.trim());
                    }
                }
                HomeActivity_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).isNewLogin(true).start();
                finish();
                //view.loadUrl("javascript:window.HTMLOUT.showHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');");

            }

        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            if (url.startsWith(Config.LOGIN_BASE_URL)) {
                String alternate = url.replace("localhost", "10.0.2.2");
                view.loadUrl(alternate);
                return true;
            }

            return false;
        }
    }

    class MyJavaScriptInterface {
        @JavascriptInterface
        public void showHTML(String html) {
            String htmlString = Html.fromHtml(html).toString();
            Log.i("HtmlSTR", htmlString);


        }
    }
}
