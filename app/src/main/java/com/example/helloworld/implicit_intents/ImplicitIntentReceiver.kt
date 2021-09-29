package com.example.helloworld.implicit_intents


import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.helloworld.R


class ImplicitIntentReceiver : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_impl_intent_receiver)

        val intent = intent
        val uri: Uri? = intent.data
        if (uri != null) {
            val uri_string = "URI:$uri"
            val textView = findViewById<TextView>(R.id.text_uri_message)
            textView.text = uri_string
        }
    }
}