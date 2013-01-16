package com.msi.manning.chapter10.xmlanimation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;

public class XMLAnimation extends Activity 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        
//     // Hook into the object to be animated.
//       TextView animWindow = (TextView)findViewById(0x7f040000);
//
//        // Load the animation from XML (XML file is res/anim/move_animation.xml).
//        Animation anim = AnimationUtils.loadAnimation(XMLAnimation.this, R.drawable.simple_animation);
//        anim.setRepeatMode(Animation.NO_REPEAT);
//
//        // Play the animation.
//        animWindow.startAnimation(anim);
        
     // Load the ImageView that will host the animation and
        // set its background to our AnimationDrawable XML resource.
        ImageView img = (ImageView)findViewById(R.id.simple_anim);
        img.setBackground(R.anim.simple_animation);

        
        MyAnimationRoutine mar = new MyAnimationRoutine();
        MyAnimationRoutine2 mar2 = new MyAnimationRoutine2();
        
        Timer t = new Timer(false);
        t.schedule(mar, 100);
        Timer t2 = new Timer(false);
        t2.schedule(mar2, 5000);
        

        
    }

    class MyAnimationRoutine extends TimerTask
    {
    	MyAnimationRoutine()
    	{
    	}
    	
    	
    	public void run()
    	{
        	ImageView img = (ImageView)findViewById(R.id.simple_anim);
            // Get the background, which has been compiled to an AnimationDrawable object.
            AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();

            // Start the animation (looped playback by default).
            frameAnimation.start();
    	}
    }


    class MyAnimationRoutine2 extends TimerTask
    {
    	MyAnimationRoutine2()
    	{
    	}
    	
    	
    	public void run()
    	{
        	ImageView img = (ImageView)findViewById(R.id.simple_anim);
            // Get the background, which has been compiled to an AnimationDrawable object.
            AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();

            // stop the animation (looped playback by default).
            frameAnimation.stop();
    	}
    }





}


