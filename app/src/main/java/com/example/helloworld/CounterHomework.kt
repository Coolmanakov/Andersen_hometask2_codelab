package com.example.helloworld

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CounterHomework : AppCompatActivity() {
    private var mCount = 0;
    private var counter : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter_homework)

        savedInstanceState.let {
            counter?.text = it?.getString("counter_val")
        }

        counter = findViewById(R.id.text_counter)
    }

    fun countUp(view: android.view.View) {
        mCount++
        counter?.text = mCount.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val count = counter?.text.toString()
        outState.putString("counter_val", count)
    }
}