package com.example.helloworld

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.helloworld.hello_toast.HelloToast

class SecondActivity : AppCompatActivity() {

    var mCount : TextView? = null
    companion object{
        private  val LOG_TAG = "Main Activity"
        val REPLY = "com.example.helloworld.SecondActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mCount = findViewById(R.id.count_hello)

        val count = intent.getCharSequenceExtra(HelloToast.SEND_MESSAGE)
        mCount?.text = count

        Log.d(LOG_TAG, "Main Activity calling onCreate() ")
    }
}