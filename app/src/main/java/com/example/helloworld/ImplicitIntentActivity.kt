package com.example.helloworld

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat


class ImplicitIntentActivity : AppCompatActivity() {

    private var mWebsiteEditText : EditText? = null
    private var mLocationEditText : EditText? = null
    private var mShareTextEditText : EditText? = null
    private var mPictureButton : Button? = null

    companion object{
        private  val LOG_TAG = "Main Activity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)

        mWebsiteEditText = findViewById(R.id.website_edittext)
        mLocationEditText = findViewById(R.id.location_edittext)
        mShareTextEditText = findViewById(R.id.share_edittext)
        mPictureButton = findViewById(R.id.picture_button)

        Log.d(LOG_TAG, "Main Activity calling onCreate() ")
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun openLocation(view: android.view.View) {
        val loc = mLocationEditText?.text.toString()
        val addressUri = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    fun shareText(view: android.view.View) {
        val txt = mShareTextEditText?.text.toString()
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle("Share this text with: ")
            .setText(txt)
            .startChooser()
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun openWebsite(view: android.view.View) {
        val url = mWebsiteEditText?.text.toString()
        val webPage = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webPage)

        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
        else Log.d("ImplicitIntents", "Can't handle this!");
    }

    fun take_picture(view: android.view.View) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(intent)
    }
}