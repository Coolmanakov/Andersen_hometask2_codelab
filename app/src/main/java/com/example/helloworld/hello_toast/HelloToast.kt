package com.example.helloworld.hello_toast

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.helloworld.R

class HelloToast : AppCompatActivity() {
    private var mCount = 0
    private var mShowCount : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_toast)

        mShowCount = findViewById(R.id.show_count)
    }

    fun showToast(view: View) {
        val toast : Toast = Toast.makeText(this, R.string.toast_message,Toast.LENGTH_SHORT)
        toast.show()
    }
    fun countUp(view: View) {
        mCount++
        mShowCount?.apply {
            text = "$mCount"
        }
    }
}