package com.example.anim;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.Button;
import android.view.View;
import android.media.MediaPlayer;



public class anim extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button FadeIn = (Button)findViewById(R.id.FadeIn);
        Button FadeOut = (Button)findViewById(R.id.FadeOut);
        Button PushLeftIn = (Button)findViewById(R.id.PushLeftIn);
        Button PushLeftOut = (Button)findViewById(R.id.PushLeftOut);
        Button PushRightIn = (Button)findViewById(R.id.PushRightIn);
        Button PushRightOut = (Button)findViewById(R.id.PushRightOut);
        Button Rotation = (Button)findViewById(R.id.Rotation);
        final ImageView image = (ImageView) findViewById(R.id.MainImg);
        final Animation fadein = 
            AnimationUtils.loadAnimation(this, R.anim.fadein);
        final Animation fadeout = 
            AnimationUtils.loadAnimation(this, R.anim.fadeout);
        final Animation push_left_in = 
            AnimationUtils.loadAnimation(this, R.anim.push_left_in);
        final Animation push_left_out = 
            AnimationUtils.loadAnimation(this, R.anim.push_left_out);
        final Animation push_right_in = 
            AnimationUtils.loadAnimation(this, R.anim.push_right_in);
        final Animation push_right_out = 
            AnimationUtils.loadAnimation(this, R.anim.push_right_out);
        final Animation rotation = 
            AnimationUtils.loadAnimation(this, R.anim.rotation);
         
        final AnimationDrawable frameanimation = AnimationDrawable();
        
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet1), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet2), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet3), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet4), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet5), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet6), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet7), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet8), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet9), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet10), 100);
    	frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet11), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet12), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet13), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet14), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet15), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet16), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet17), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet18), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet19), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet20), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet21), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet22), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet23), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet24), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet25), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet26), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet27), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet28), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet29), 100);
        frameanimation.addFrame(getResources().getDrawable(R.drawable.vpet30), 100);
   		frameanimation.setOneShot(false);
        

	
	FadeIn.setOnClickListener(new View.OnClickListener() {
	public void onClick(View parent) {
	image.setImageResource(R.drawable.loadpic1);
	image.startAnimation(fadein);
		}
	});
	   FadeOut.setOnClickListener(new View.OnClickListener() {
	public void onClick(View parent) {
	image.startAnimation(fadeout);
	image.setImageResource(R.drawable.loadpic2);
		}
	});
	
	PushLeftIn.setOnClickListener(new View.OnClickListener() {
	public void onClick(View parent) {
	image.setImageResource(R.drawable.loadpic3);
	image.startAnimation(push_left_in);
		}
	});
	
	   PushLeftOut.setOnClickListener(new View.OnClickListener() {
	public void onClick(View parent) {
	image.startAnimation(push_left_out);
	image.setImageResource(R.drawable.loadpic4);
		}
	});
	   PushRightIn.setOnClickListener(new View.OnClickListener() {
	public void onClick(View parent) {
	image.setImageResource(R.drawable.loadpic5);
	image.startAnimation(push_right_in);
		}
	});
	   PushRightOut.setOnClickListener(new View.OnClickListener() {
	public void onClick(View parent) {
	image.startAnimation(push_right_out);
	image.setImageResource(R.drawable.loadpic6);
		}
	});
	   Rotation.setOnClickListener(new View.OnClickListener() {
	public void onClick(View parent) {
	image.setBackgroundDrawable(frameanimation);
	image.post(new Starter());
	//image.startAnimation(rotation);
	//image.setImageResource(R.drawable.loadpic);
		}
	});
    }
     class Starter implements Runnable {

        public void run() {
            frameanimation.start();        
        }
        

    }
}
