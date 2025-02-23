package com.example.yourapp; // Replace with your package name

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson08_webview.R;

public class TwoActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        // Initialize WebView
        webView = findViewById(R.id.webview);

        // Configure WebView settings
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enable JavaScript
        webSettings.setDomStorageEnabled(true); // Enable DOM storage if needed

        // Set WebViewClient to handle links within the WebView
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url); // Load the URL within the WebView
                return true; // Indicate that the WebView handles the URL
            }
        });

        // Load a URL
        webView.loadUrl("https://www.example.com"); // Replace with your desired URL
    }

    @Override
    public void onBackPressed() {
        // Handle back button press to navigate back in WebView history
        if (webView.canGoBack()) {
            webView.goBack(); // Go back in WebView history
        } else {
            super.onBackPressed(); // Exit the activity if no history is available
        }
    }
}