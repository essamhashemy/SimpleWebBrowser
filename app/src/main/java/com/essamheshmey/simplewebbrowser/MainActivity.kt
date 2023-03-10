package com.essamheshmey.simplewebbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Patterns
import android.webkit.URLUtil
import android.webkit.WebView
import android.widget.EditText
import android.widget.ImageButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val url_text:EditText=findViewById(R.id.url_text)
        val return_btn:ImageButton=findViewById(R.id.return_btn)
        val search_btn:ImageButton=findViewById(R.id.search_btn)
        val webview:WebView=findViewById(R.id.webview)
        webview.loadUrl("https://github.com/essamhashemy")
        webview.settings.javaScriptEnabled = true
        webview.canGoBack()
        webview.webViewClient = WebClient(this)

        search_btn.setOnClickListener {
            //GlobalScope.launch {
            val URL =url_text.text.toString()
           if (URLUtil.isValidUrl(URL)){ webview.loadUrl(URL)}
          else{ webview.loadUrl("https://www.google.com/search?q=${URL}")}}
     //   }

        return_btn.setOnClickListener {webview.goBack()}
    }
}