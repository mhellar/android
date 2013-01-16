package com.example.HelloTabsMh;
import android.app.Activity;
import android.os.Bundle;

public class SongsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textview = new TextView(this);
        textview.setText("This is the Songs tab");
        setContentView(textview);
    }
}
