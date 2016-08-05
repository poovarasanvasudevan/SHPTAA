package in.shpt.application;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mikepenz.iconics.Iconics;

import org.androidannotations.annotations.EApplication;

import in.shpt.networking.APIProvider;
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

    @Override
    public void onCreate() {
        super.onCreate();

        Iconics.init(this);

    }

    public APIProvider getAdapter() {
        if (apiService == null) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            apiService = retrofit.create(APIProvider.class);

            return apiService;
        } else {
            return apiService;
        }
    }
}
