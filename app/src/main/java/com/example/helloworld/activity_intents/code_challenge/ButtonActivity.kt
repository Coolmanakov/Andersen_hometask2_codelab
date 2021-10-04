package com.example.helloworld.activity_intents.code_challenge

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContract
import androidx.annotation.RequiresApi
import com.example.helloworld.R

class ButtonActivity : AppCompatActivity() {

    private var first_btn : Button? = null
    private var second_btn : Button? = null
    private var third_btn : Button? = null
    companion object{
        val SHOW_PASSAGE = "show passage"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        first_btn = findViewById(R.id.first_btn)
        second_btn = findViewById(R.id.second_btn)
        third_btn = findViewById(R.id.third_btn)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun showPassage(view: android.view.View) {

        val passageIntent = Intent(this, TextPassageActivity::class.java)

        val str_id = view.tooltipText
        passageIntent.putExtra(SHOW_PASSAGE, str_id)
        startActivity(passageIntent)
    }


}