package net.sankichi.android.stationsearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.sankichi.android.stationsearch.api.ServiceProvider;
import net.sankichi.android.stationsearch.model.Station;
import net.sankichi.android.stationsearch.model.StationResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView lineText;
    private TextView kanaText;
    private TextView nameText;
    private TextView distanceText;
    private TextView prevText;
    private TextView nextText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_text);
        lineText = (TextView) findViewById(R.id.line_text);
        kanaText = (TextView) findViewById(R.id.kana_text);
        nameText = (TextView) findViewById(R.id.name_text);
        distanceText = (TextView) findViewById(R.id.distance_text);
        prevText = (TextView) findViewById(R.id.prev_text);
        nextText = (TextView) findViewById(R.id.next_text);
    }

    public void searchStation(View view) {
        String postal = editText.getText().toString();

        Call<StationResponse> call = ServiceProvider.getEkidataService().station(postal);
        call.enqueue(new Callback<StationResponse>() {
            @Override
            public void onResponse(Call<StationResponse> call, Response<StationResponse> response) {
                Station station = response.body().response.station.get(0);
                showStation(station);
            }

            @Override
            public void onFailure(Call<StationResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "通信失敗", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showStation(Station station) {
        lineText.setText(station.line);
        kanaText.setText(station.kana);
        nameText.setText(station.name);
        distanceText.setText((int) station.distance + "m");
        prevText.setText("前の駅: " + station.prev);
        nextText.setText("次の駅: " + station.next);
    }
}
