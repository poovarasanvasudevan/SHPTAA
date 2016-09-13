package in.shpt.application;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mikepenz.iconics.Iconics;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.ParseUser;
import com.parse.PushService;
import com.parse.SaveCallback;

import org.androidannotations.annotations.EApplication;
import org.androidannotations.annotations.SystemService;

import in.shpt.config.Config;
import in.shpt.networking.APIProvider;
import okhttp3.OkHttpClient;
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
    String BASE_URL = "http://192.168.1.104:8080/";
    APIProvider apiService = null;

    @SystemService
    ConnectivityManager connectivityManager;

    @SystemService
    TelephonyManager telephonyManager;

    @Override
    public void onCreate() {


        Iconics.init(this);
        Ollie.with(this)
                .setName("shpt")
                .setVersion(1)
                .setLogLevel(Ollie.LogLevel.FULL)
                .setCacheSize(128)
                .init();


        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("herokuApp")
                .enableLocalDataStore()
                .clientKey("herokuApp")
                .server("https://agile-cliffs-51843.herokuapp.com/parse/")
                .build()
        );

        ParsePush.subscribeInBackground("");


        ParseInstallation parseInstallation = ParseInstallation.getCurrentInstallation();
        parseInstallation.saveInBackground();


        super.onCreate();
    }


    public APIProvider getAdapter() {
        if (apiService == null) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    // .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            apiService = retrofit.create(APIProvider.class);

            return apiService;
        } else {
            return apiService;
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
