package com.example.helloworld.activity_intents

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.helloworld.R

class SecondActivity : AppCompatActivity() {
    private var textView : TextView? = null
    private  var mReply : EditText? = null

    companion object{
        val  EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY"
        private  val LOG_TAG = SecondActivity.javaClass.canonicalName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "onCreate()")
        setContentView(R.layout.activity_second)
        mReply = findViewById(R.id.editText_second)

        val message = intent.getStringExtra(FirstActivity.EXTRA_MESSAGE)
        textView = findViewById(R.id.text_message)
        textView?.apply {
            text = message
        }

    }

    fun returnReply(view: View) {
        val reply = mReply?.text.toString()
        val replyIntent = Intent()

        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onStart()")
    }
    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause()")
    }
    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop()")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy()")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart()")
    }
}