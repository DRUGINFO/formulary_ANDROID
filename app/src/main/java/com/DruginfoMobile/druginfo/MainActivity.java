package com.DruginfoMobile.druginfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.DruginfoMobile.druginfo.R;

public class MainActivity extends AppCompatActivity {

    WebView myWebview;
    private long time= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebview = findViewById(R.id.webView_wrap);
        myWebview.getSettings().setJavaScriptEnabled(true);

        myWebview.loadUrl("https://testformulary.druginfo.co.kr/intro");
        myWebview.setWebChromeClient(new WebChromeClient());
        myWebview.setWebViewClient(new WebViewClientClass());
    }

    @Override
    public void onBackPressed(){
            if(System.currentTimeMillis() - time >= 2000){
                time=System.currentTimeMillis();
                Toast.makeText(getApplicationContext(),"한번더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
            }
            else if(System.currentTimeMillis() - time < 2000 ){
            finish();
        }
    }

    private class WebViewClientClass extends WebViewClient {//페이지 이동
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("check URL",url);
            view.loadUrl(url);
            return true;
        }
    }
}


