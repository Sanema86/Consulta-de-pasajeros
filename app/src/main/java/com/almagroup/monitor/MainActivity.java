package com.almagroup.monitor;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.graphics.Color;
import android.view.ViewGroup;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;

public class MainActivity extends Activity {
    private WebView web;
    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        getWindow().setStatusBarColor(Color.rgb(18,63,53));
        getWindow().setNavigationBarColor(Color.rgb(18,63,53));
        web = new WebView(this);
        web.setLayoutParams(new ViewGroup.LayoutParams(-1,-1));
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setDomStorageEnabled(true);
        web.setWebViewClient(new WebViewClient());
        web.setWebChromeClient(new WebChromeClient());
        setContentView(web);
        try {
            InputStream in = getAssets().open("index.html");
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096]; int n;
            while ((n = in.read(buffer)) > 0) out.write(buffer, 0, n);
            in.close();
            String html = out.toString("UTF-8");
            web.loadDataWithBaseURL("https://micronauta.dnsalias.net/usuario/yaviene/", html, "text/html", "UTF-8", null);
        } catch (Exception e) { web.loadData("<h3>Error al cargar la aplicación</h3>", "text/html", "UTF-8"); }
    }
    @Override public void onBackPressed() {
        if (web != null && web.canGoBack()) web.goBack(); else super.onBackPressed();
    }
}
