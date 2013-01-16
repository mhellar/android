package com.example.HelloTabsMh;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideosActivity extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoview);
		VideoView videoView =(VideoView)findViewById(R.id.videoView);
    	MediaController mediaController= new MediaController(this);
    	mediaController.setAnchorView(videoView);        
    	Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.a3);        
    	videoView.setMediaController(mediaController);
    	videoView.setVideoURI(uri);        
    	videoView.requestFocus();
    	videoView.start();
    }
}
