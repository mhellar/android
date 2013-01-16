package com.example.HelloTabsMh;
import android.widget.Button;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Buttons extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttonview);
        final ImageView image = (ImageView) findViewById(R.id.imageView1);
        Button myButton1 = (Button)findViewById(R.id.button1);
        Button myButton2 = (Button)findViewById(R.id.button2);
        
    myButton1.setOnClickListener(new View.OnClickListener() {
	public void onClick(View parent) {
	image.setImageResource(R.drawable.sample_6);
		}
	});
	    myButton2.setOnClickListener(new View.OnClickListener() {
	public void onClick(View parent) {
	image.setImageResource(R.drawable.sample_7);
		}
	});
    }
}
