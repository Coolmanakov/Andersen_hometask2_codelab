package com.example.helloworld.hello_toast

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import com.example.helloworld.R

class BroadcastActivity : AppCompatActivity() {
    private var mCount = 0
    private var mShowCount : TextView? = null

    var activityLauncher = registerForActivityResult(SecondActivityContract()){result ->
        mShowCount?.text = result.toString()
    }

    companion object{
        val SEND_MESSAGE = "com.example.helloworld.HelloToast"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast)

        mShowCount = findViewById(R.id.show_count)
    }

//    fun showToast(view: View) {
//        val toast : Toast = Toast.makeText(this, R.string.toast_message,Toast.LENGTH_SHORT)
//        toast.show()
//    }

    fun countUp(view: View) {
        mCount++
        mShowCount?.apply {
            text = "$mCount"
        }
    }

    fun sayHello(view: View) {
        val number = mShowCount?.text
        activityLauncher.launch(number)
    }

    class SecondActivityContract : ActivityResultContract<CharSequence?, Int>(){
        override fun createIntent(context: Context, input: CharSequence?): Intent {
            return Intent(context, ReceiverActivity::class.java)
                .putExtra(SEND_MESSAGE, input)
        }

        override fun parseResult(resultCode: Int, intent: Intent?): Int? = when{
            resultCode != Activity.RESULT_OK -> 0
            else -> intent?.getIntExtra(ReceiverActivity.REPLY, 0)

        }

    }
}