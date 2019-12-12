package com.example.myloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // this action launches the quiz question activity when the Click to START QUIZ button is clicked.
       button_start_quiz.setOnClickListener {
           val intent = Intent(this,
               QuestionFunActivity::class.java)
           // start Quiz question Activity
           startActivity(intent)
       }
    }
}
