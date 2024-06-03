package com.kognitivist.androidlessons

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {

    //private val hCaptcha = HCaptcha.getClient(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{

        }

        /*hCaptcha.setup(BuildConfig.SITE_KEY).verifyWithHCaptcha()
        hCaptcha.addOnSuccessListener { response: HCaptchaTokenResponse ->
            val userResponseToken = response.tokenResult
            val intent = Intent()
            intent.putExtra("captcha", userResponseToken)
            setResult(RESULT_OK, intent)
            finish()
        }.addOnFailureListener { e: HCaptchaException ->
            Log.d("hCaptcha", "hCaptcha failed: " + e.getMessage() + "(" + e.getStatusCode() + ")")
            setResult(RESULT_CANCELED)
            finish()
        }.addOnOpenListener {
            Log.d("hCaptcha", "hCaptcha is now visible.")
        }*/
    }
}



