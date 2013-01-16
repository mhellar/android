package com.example.HelloTabsMh;
import android.app.Activity;
import android.webkit.WebView;
import 	android.webkit.WebViewClient;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class WebView1 extends Activity {
    private class HelloWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
    
    }
    public void onCreate(Bundle savedInstanceState) {
    
    super.onCreate(savedInstanceState);
    setContentView(R.layout.webview);
    WebView mWebView;
    mWebView = (WebView) findViewById(R.id.webview);
    mWebView.getSettings().setJavaScriptEnabled(true);
    mWebView.loadUrl("http://www.google.com");
    mWebView.setWebViewClient(new HelloWebViewClient());
   }

}

