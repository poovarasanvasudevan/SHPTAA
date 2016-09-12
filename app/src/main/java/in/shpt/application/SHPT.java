package in.shpt.application;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mikepenz.iconics.Iconics;
import com.parse.Parse;
import com.parse.ParseInstallation;

import org.androidannotations.annotations.EApplication;
import org.androidannotations.annotations.SystemService;

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
    String BASE_URL = "http://10.0.2.2:8080/";
    APIProvider apiService = null;

    @SystemService
    ConnectivityManager connectivityManager;

    @Override
    public void onCreate() {
        super.onCreate();

        Iconics.init(this);
        Ollie.with(this)
                .setName("shpt")
                .setVersion(1)
                .setLogLevel(Ollie.LogLevel.FULL)
                .setCacheSize(128)
                .init();


        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("SHPTAPP")
                .enableLocalDataStore()
                .clientKey("masterkey")
                .server("http://10.0.2.2:1337/parse/")
                .build()
        );

        ParseInstallation.getCurrentInstallation().saveInBackground();



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
