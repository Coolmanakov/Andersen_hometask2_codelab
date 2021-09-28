package com.example.helloworld

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ScrollViewActivity : AppCompatActivity() {

    companion object{
        private  val LOG_TAG = "Main Activity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hometask)

        Log.d(LOG_TAG, "Main Activity calling onCreate() ")
    }
}