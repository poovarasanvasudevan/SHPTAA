package in.shpt.application;

import android.app.Application;
import android.content.ContextWrapper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mikepenz.iconics.Iconics;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.pixplicity.easyprefs.library.Prefs;

import org.androidannotations.annotations.EApplication;
import org.androidannotations.annotations.SystemService;
import org.androidannotations.annotations.sharedpreferences.Pref;

import java.io.IOException;

import in.shpt.config.Config;
import in.shpt.networking.APIProvider;
import in.shpt.preference.SHPTPreferences_;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import ollie.Ollie;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by poovarasanv on 3/8/16.
 */

@EApplication
public class SHPT extends Application {

    Retrofit retrofit = null;
    APIProvider apiService = null;

    @SystemService
    ConnectivityManager connectivityManager;

    @SystemService
    TelephonyManager telephonyManager;


    @Pref
    SHPTPreferences_ shptPreferences_;

    @Override
    public void onCreate() {


        Iconics.init(this);
        Ollie.with(this)
                .setName("shpt")
                .setVersion(1)
                .setLogLevel(Ollie.LogLevel.FULL)
                .setCacheSize(128)
                .init();

        Parse.enableLocalDatastore(this);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .enableLocalDataStore()
                .applicationId("herokuApp")
                .clientKey("herokuApp")
                .server("https://agile-cliffs-51843.herokuapp.com/parse/")
                .build()
        );


        ParsePush.subscribeInBackground("");


        ParseInstallation parseInstallation = ParseInstallation.getCurrentInstallation();
        parseInstallation.saveInBackground();


        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
        super.onCreate();
    }


    public APIProvider getAdapter() {

        apiService = null;
        if (Prefs.getString(Config.COOKIE, null) != null) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addInterceptor(new AddCookiesInterceptor())
                    .build();


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Config.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            apiService = retrofit.create(APIProvider.class);

            return apiService;
        } else {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Config.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            apiService = retrofit.create(APIProvider.class);

            return apiService;
        }

    }

    public class AddCookiesInterceptor implements Interceptor {

        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request.Builder builder = chain.request().newBuilder();

            builder.addHeader("Cookie", "PHPSESSID=" + Prefs.getString(Config.COOKIE, null) + "; display=list");
            builder.addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36 OPR/39.0.2256.71");
            return chain.proceed(builder.build());
        }
    }


    public boolean isInternetAvailable() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;


        NetworkInfo[] netInfo = connectivityManager
                .getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }


}
