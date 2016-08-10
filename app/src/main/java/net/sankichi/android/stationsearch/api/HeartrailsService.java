package net.sankichi.android.stationsearch.api;

import net.sankichi.android.stationsearch.model.StationResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HeartrailsService {

    @GET("/api/json?method=getStations")
    Call<StationResponse> station(@Query("postal") String postal);

}
