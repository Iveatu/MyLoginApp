package com.example.myloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result_main.*

class ResultMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_result_main)
        // this terminates the quiz app when the END QUIZ button is clicked
        end.setOnClickListener {
            // end
            finishAffinity()
        }

    }
}