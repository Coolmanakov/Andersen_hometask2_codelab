package com.example.helloworld.activity_intents

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
import androidx.core.view.isVisible
import com.example.helloworld.R

class FirstActivity : AppCompatActivity() {
    private var mMessageEditText : EditText? = null
    private var mReplyHeadTextView : TextView? = null
    private var mReplyTextView : TextView? = null

    var resultLauncher = registerForActivityResult(MySecondActivityContract()){ result ->


        mReplyHeadTextView?.visibility = View.VISIBLE
        mReplyTextView?.text = result
        mReplyTextView?.visibility = View.VISIBLE
    }

    companion object{
        private  val LOG_TAG = FirstActivity.javaClass.canonicalName
        val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
        val TEXT_REQUEST = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "onCreate()")

        setContentView(R.layout.activity_first)

        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);

        savedInstanceState?.let {
            val isVisible = savedInstanceState.getBoolean("reply_visible")
            if(isVisible){
                mReplyHeadTextView?.visibility = View.VISIBLE
                mReplyTextView?.text = savedInstanceState.getString("reply_text")
                mReplyTextView?.visibility = View.VISIBLE
            }
        }


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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mReplyHeadTextView?.isVisible?.let {
            outState.putBoolean("reply_visible", it)
            outState.putString("reply_text", mReplyHeadTextView?.text.toString())}
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