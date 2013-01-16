package com.example.HelloTabsMh;
import android.app.Activity;
import android.os.Bundle;

public class AlbumsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textview = new TextView(this);
        textview.setText("This is the Albums tab");
        setContentView(textview);
    }
}
