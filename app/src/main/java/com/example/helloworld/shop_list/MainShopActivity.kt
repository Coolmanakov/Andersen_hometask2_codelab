package com.example.helloworld.shop_list

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import com.example.helloworld.R
import com.example.helloworld.activity_intents.SecondActivity
import java.util.ArrayList

class MainShopActivity : AppCompatActivity() {

    private var item1 : TextView? = null
    private var item2 : TextView? = null
    private var item3 : TextView? = null
    private var item4 : TextView? = null
    private var item5 : TextView? = null
    private var item6 : TextView? = null
    private var item7 : TextView? = null
    private var item8 : TextView? = null
    private var item9 : TextView? = null
    private var item10 : TextView? = null
    private lateinit var listTextViews : List<TextView?>

    private var addItem : Button? = null

    companion object{
        private val GET_ITEM = "give me an item"
    }


    val launcher = registerForActivityResult(ShopActivityCiContract()){
        findNonEmptyTextView(it)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_shop)

        item1 = findViewById(R.id.item1)
        item2 = findViewById(R.id.item2)
        item3 = findViewById(R.id.item3)
        item4 = findViewById(R.id.item4)
        item5 = findViewById(R.id.item5)
        item6 = findViewById(R.id.item6)
        item7 = findViewById(R.id.item7)
        item8 = findViewById(R.id.item8)
        item9 = findViewById(R.id.item9)
        item10 = findViewById(R.id.item10)
        addItem = findViewById(R.id.add_item)

        listTextViews = listOf(item1, item2, item3, item4, item5,item6, item7, item8, item9, item10)
    }

    fun chooseItem(view: android.view.View) {

        launcher.launch("take item")

    }


    class ShopActivityCiContract : ActivityResultContract<String, String>(){
        override fun createIntent(context: Context, input: String?): Intent {
            return Intent(context,  SecondShopActivity::class.java)
                .putExtra(GET_ITEM, input)
        }

        override fun parseResult(resultCode: Int, intent: Intent?): String? = when{
            resultCode != Activity.RESULT_OK -> null
            else -> intent?.getStringExtra(SecondShopActivity.REPLY_ITEM)
        }

    }
    private fun findNonEmptyTextView(item : String){
        listTextViews?.forEach {
            if(it?.text == ""){
                it?.text = item
                return
            }
        }
    }
}