package com.example.helloworld

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var mMessageEditText : EditText? = null
    private var mReplyHeadTextView : TextView? = null
    private var mReplyTextView : TextView? = null

    var resultLauncher = registerForActivityResult(MySecondActivityContract()){ result ->


        mReplyHeadTextView?.visibility = View.VISIBLE
        mReplyTextView?.text = result
        mReplyTextView?.visibility = View.VISIBLE
    }

    companion object{
        private  val LOG_TAG = MainActivity.javaClass.canonicalName
        val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
        val TEXT_REQUEST = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);

        Log.d(LOG_TAG, "Main Activity calling onCreate() ")
    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!");

        val message = mMessageEditText?.text.toString()
        resultLauncher.launch(message)
    }

    class MySecondActivityContract : ActivityResultContract<String, String?>(){

        override fun createIntent(context: Context, input: String?): Intent {
            return Intent(context, SecondActivity::class.java)
                .putExtra(EXTRA_MESSAGE, input)
        }

        override fun parseResult(resultCode: Int, intent: Intent?): String? = when{
            resultCode != Activity.RESULT_OK -> null
            else -> intent?.getStringExtra(SecondActivity.EXTRA_REPLY)
        }

    }
}