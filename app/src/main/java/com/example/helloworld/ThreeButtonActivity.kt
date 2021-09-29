package com.example.helloworld

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ThreeButtonActivity : AppCompatActivity() {
    private var mCount = 0
    private var mShowCount : TextView? = null
    private var buttonZero : Button? = null
    private var buttonCount : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three_button)

        mShowCount = findViewById(R.id.show_count)
        buttonZero = findViewById(R.id.button_zero)
        buttonCount = findViewById(R.id.button_count)
    }

    fun showToast(view: View) {
        val toast : Toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
        toast.show()
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    fun countUp(view: View) {
        mCount++
        mShowCount?.apply {
            text = "$mCount"
        }
        buttonCount?.apply {
            background = if(isEven()) getDrawable(R.color.teal_200)
            else getDrawable(R.color.black)
        }
        buttonZero?.apply {
            background = getDrawable(R.color.purple_200)
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun countToZero(view: View) {
        mCount = 0
        mShowCount?.apply {
            text = "$mCount"
        }
    }

    private fun isEven() : Boolean = mCount % 2 == 0
}