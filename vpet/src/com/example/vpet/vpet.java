package com.example.vpet;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class vpet
 extends Activity {
    
    AnimationDrawable animation;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        animation = new AnimationDrawable();
        animation.addFrame(getResources().getDrawable(R.drawable.vpet1), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet2), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet3), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet4), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet5), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet6), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet7), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet8), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet9), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet10), 100);
    	animation.addFrame(getResources().getDrawable(R.drawable.vpet11), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet12), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet13), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet14), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet15), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet16), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet17), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet18), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet19), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet20), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet21), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet22), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet23), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet24), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet25), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet26), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet27), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet28), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet29), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.vpet30), 100);
   
        animation.setOneShot(false);
        
        ImageView imageAnim =  (ImageView) findViewById(R.id.anim);
        imageAnim.setBackgroundDrawable(animation);
        
        // run the start() method later on the UI thread
        imageAnim.post(new Starter());
        
    }
    
    class Starter implements Runnable {

        public void run() {
            animation.start();        
        }
        

    }
}