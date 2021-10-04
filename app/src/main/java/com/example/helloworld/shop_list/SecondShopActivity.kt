package com.example.helloworld.shop_list

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import com.example.helloworld.R

class SecondShopActivity : AppCompatActivity() {

    companion object{
        val REPLY_ITEM = "take an item"
    }
    private var cheese : Button? = null
    private var rice : Button? = null
    private var apple : Button? = null
    private var sugar : Button? = null
    private var chips : Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_shop)

        cheese = findViewById(R.id.cheese)
        rice = findViewById(R.id.rice)
        apple = findViewById(R.id.apple)
        sugar = findViewById(R.id.sugar)
        chips = findViewById(R.id.chips)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun replyItem(view: android.view.View) {

        val replyIntent = Intent()

        val item = view.tooltipText?.toString()
        replyIntent.putExtra(REPLY_ITEM, item)
        setResult(RESULT_OK, replyIntent)
        finish()
    }
}