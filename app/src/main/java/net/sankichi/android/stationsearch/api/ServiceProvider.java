package net.sankichi.android.stationsearch.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceProvider {

    private static Retrofit retrofit = null;

    private static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://geoapi.heartrails.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static HeartrailsService getEkidataService() {
        return getRetrofit().create(HeartrailsService.class);
    }

}
