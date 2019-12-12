package com.example.myloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // adds functionalities to the components of the login activity
    log_me_in.setOnClickListener {
        val emailAdd=EmailID.text.toString()
        val passwordItem=editPassword.text.toString()
        Log.d("MainActivity","Email is" + emailAdd)
        Log.d("MainActivity","password: $passwordItem")
        FirebaseAuth.getInstance().signInWithEmailAndPassword(emailAdd, passwordItem)

            // checks the success of login action when the login button is clicked
            .addOnCompleteListener {
                if(!it.isSuccessful)return@addOnCompleteListener
                Log.d("MainActivity","Successfully logged in: ${it.result?.user?.uid}")
                Toast.makeText(this, "Successfully logged in user:${it.result?.user?.uid}", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,
                    WelcomeActivity::class.java)
                // start registration Activity
                startActivity(intent)

            }
             // checks the failure of the login action when login button is clicked
            .addOnFailureListener {
                Log.d("MainActivity","Login unsuccessful: ${it.message}")
                Toast.makeText(this,"Login unsuccessful: ${it.message}", Toast.LENGTH_SHORT).show()
            }

    }
            // when the sign up button is clicked, the sign up activity is launched from here
            registerView.setOnClickListener {
                val intent = Intent(this,
                    RegisterMeActivity::class.java)
                // start registration Activity
                startActivity(intent)
}

}


}
