package net.sankichi.android.stationsearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
}
