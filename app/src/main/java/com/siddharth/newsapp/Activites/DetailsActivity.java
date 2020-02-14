package com.siddharth.newsapp.Activites;


import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.siddharth.newsapp.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        WebView webView = findViewById(R.id.webview);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String url = bundle.getString("url");

            webView.loadUrl(url);
        }


    }
}