package com.mhellar.stopmo;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class stopmo extends Activity
{
	AnimationDrawable animation;
	public int i;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button frame50 = (Button)findViewById(R.id.frame50);
        animation = new AnimationDrawable();
        animation.setOneShot(false);
        i = 10;
        
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00026), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00027), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00028), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00029), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00030), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00031), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00032), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00033), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00034), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00035), i);
    	animation.addFrame(getResources().getDrawable(R.drawable.candle_00036), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00037), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00038), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00039), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00040), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00041), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00042), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00043), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00044), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00045), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00046), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00047), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00048), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00049), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00050), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00051), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00052), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00053), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00054), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00055), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00056), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00057), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00058), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00059), i);
    	animation.addFrame(getResources().getDrawable(R.drawable.candle_00060), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00061), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00062), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00063), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00064), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00065), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00066), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00067), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00068), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00069), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00070), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00071), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00072), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00073), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00074), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00075), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00076), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00077), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00078), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00079), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00080), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00081), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00082), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00083), i);
    	animation.addFrame(getResources().getDrawable(R.drawable.candle_00084), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00085), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00086), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00087), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00088), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00089), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00090), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00091), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00092), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00093), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00094), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00095), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00096), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00097), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00098), i);
        animation.addFrame(getResources().getDrawable(R.drawable.candle_00099), i);
        
        
        ImageView imageAnim =  (ImageView) findViewById(R.id.anim);
        imageAnim.setBackgroundDrawable(animation);

        animation.start();
        
		frame50.setOnClickListener(new View.OnClickListener() {
		public void onClick(View parent) {
		animation.stop();
		i = 100;
		animation.start();
		}
		});
        
    }
    
}
