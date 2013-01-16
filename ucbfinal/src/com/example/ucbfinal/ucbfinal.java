package com.example.ucbfinal;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.app.AlertDialog;


public class ucbfinal extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        
        final Toast msg = Toast.makeText(ucbfinal.this,"Toast Message", Toast.LENGTH_SHORT);
        
        final AlertDialog alertDialog = new AlertDialog.Builder(ucbfinal.this).create();
        alertDialog.setTitle("Alert Dialog..");
        alertDialog.setMessage("UCB Android Final");

        
        button1.setOnClickListener(new View.OnClickListener() {
		public void onClick(View parent) {
		
        msg.show();
		}
	});
	
		button2.setOnClickListener(new View.OnClickListener() {
		public void onClick(View parent) {
		alertDialog.show();

		}
	});
    }
}
