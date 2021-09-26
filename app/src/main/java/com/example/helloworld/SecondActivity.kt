package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private var textView : TextView? = null
    private  var mReply : EditText? = null

    companion object{
        val  EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        mReply = findViewById(R.id.editText_second)

        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
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
}