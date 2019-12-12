package com.example.myloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler


/**
 * A splash screen created by iveatu
 */
class SplashShowActivity : AppCompatActivity() {
    // declaration of the handler and splash screen action time for this spalsh screen activity
    private var watchHandler: Handler? = null
    private val slowSplash: Long = 5000 //5 seconds

    //declares the variable for screen action of the splash screen
    internal val mlaunchable: Runnable = Runnable {
        if (!isFinishing) {
            // launches the next activity(main activity which is the login activity when the time elapses
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_show)

        //Initialize the Handler
        watchHandler = Handler()

        //Navigate with delay
        watchHandler!!.postDelayed(mlaunchable, slowSplash)

    }
// This function is called to destroy the splash screen activity not to load again
    public override fun onDestroy() {

        if (watchHandler != null) {
            watchHandler!!.removeCallbacks(mlaunchable)
        }

        super.onDestroy()
    }

}
