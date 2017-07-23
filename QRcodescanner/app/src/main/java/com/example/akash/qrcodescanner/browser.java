package com.example.akash.qrcodescanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class browser extends AppCompatActivity {

    WebView browser;
    EditText url;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

//
//        Intent intent = getIntent();
//        String url2 = intent.getStringExtra("name");

        b = (Button) findViewById(R.id.go);
        url = (EditText) findViewById(R.id.url);
        browser = (WebView) findViewById(R.id.webview);
        browser.setWebViewClient(new mybrowser());

        browser.getSettings().setJavaScriptEnabled(true);
//
//        browser.loadUrl(url2);

//        if (url2.charAt(0)=='h')
//            browser.loadUrl(url2);
//        else if (url2.charAt(0)=='w')
//        browser.loadUrl("http://"+url2);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String url1=  url.getText().toString();
//                browser.getSettings().setJavaScriptEnabled(true);
//                if (url1.charAt(0)=='h')
//                    browser.loadUrl(url1);
//                else if (url1.charAt(0)=='w')
//                    browser.loadUrl("http://"+url1);

            }
        });
    }

    private class mybrowser extends WebViewClient
    {

    }

}
