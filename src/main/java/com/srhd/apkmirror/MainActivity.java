package com.srhd.apkmirror;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permissions();

        webView = (WebView) findViewById(R.id.APKMirror_Loader);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.apkmirror.com/");

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void permissions() {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

            if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(this, "'Reading to External Storage'-Permission Denied", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "'Reading to External Storage'-Permission Granted", Toast.LENGTH_SHORT).show();
            }

            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(this, "'Writing to External Storage'-Permission Denied", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "'Writing to External Storage'-Permission Granted", Toast.LENGTH_SHORT).show();
            }

        }

        if (android.os.Build.VERSION.SDK_INT <= android.os.Build.VERSION_CODES.LOLLIPOP) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(this, "'Reading to External Storage'-Permission Denied", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "'Reading to External Storage'-Permission Granted", Toast.LENGTH_SHORT).show();
            }

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(this, "'Writing to External Storage'-Permission Denied", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "'Writing to External Storage'-Permission Granted", Toast.LENGTH_SHORT).show();
            }
        }
    }
}