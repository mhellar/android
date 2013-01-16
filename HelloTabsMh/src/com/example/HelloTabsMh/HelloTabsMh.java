package com.example.HelloTabsMh;

import android.app.TabActivity;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.content.Intent;
import android.content.res.Resources;


public class HelloTabsMh extends TabActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    Resources res = getResources(); // Resource object to get Drawables
    TabHost tabHost = getTabHost();  // The activity TabHost
    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
    Intent intent;  // Reusable Intent for each tab

    // Create an Intent to launch an Activity for the tab (to be reused)
    intent = new Intent().setClass(this, ListView.class);

    // Initialize a TabSpec for each tab and add it to the TabHost
    spec = tabHost.newTabSpec("ListView").setIndicator("Listview",
                      res.getDrawable(R.drawable.ic_tab_listview))
                  .setContent(intent);
    tabHost.addTab(spec);

    // Do the same for the other tabs
    intent = new Intent().setClass(this, WebView1.class);
    spec = tabHost.newTabSpec("WebView1").setIndicator("WebView1",
                      res.getDrawable(R.drawable.ic_tab_webview1))
                  .setContent(intent);
    tabHost.addTab(spec);

    intent = new Intent().setClass(this, Buttons.class);
    spec = tabHost.newTabSpec("Buttons").setIndicator("Buttons",
                      res.getDrawable(R.drawable.ic_tab_buttons))
                  .setContent(intent);
    tabHost.addTab(spec);
    
     intent = new Intent().setClass(this, VideosActivity.class);
    spec = tabHost.newTabSpec("videos").setIndicator("Videos",
                      res.getDrawable(R.drawable.ic_tab_videos))
                  .setContent(intent);
    tabHost.addTab(spec);

    tabHost.setCurrentTab(2);
}
}

