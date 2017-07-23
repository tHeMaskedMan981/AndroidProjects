package com.example.akash.akatsuki;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class tsukinome extends AppCompatActivity {

    WebView browser;
    EditText url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsukinome);

        Button b = (Button) findViewById(R.id.go);
        url = (EditText) findViewById(R.id.url);
        browser = (WebView) findViewById(R.id.webview);
        browser.setWebViewClient(new mybrowser());
        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl("http://naruto.wikia.com/wiki/Eye_of_the_Moon_Plan");

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String url1=  url.getText().toString();
                browser.getSettings().setJavaScriptEnabled(true);
                browser.loadUrl("http://"+url1);

            }
        });
    }

    private class mybrowser extends WebViewClient
    {

    }
}
