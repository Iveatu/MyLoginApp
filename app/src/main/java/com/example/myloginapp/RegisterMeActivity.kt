//name of this project package
package com.example.myloginapp

//libraries used for this class
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register_me.*



class RegisterMeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_me)
        // this sets the functionalities of the sign up activity components
        button_register_me.setOnClickListener {
            val emailUser = EmaiID.text.toString()
            val passwordUser = edit_text_password.text.toString()
            Log.d("RegisterMeActivity", "Email is" + emailUser)
            Log.d("RegisterMeActivity", "password: $passwordUser")
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailUser, passwordUser)
                // checks the success of sign-up action when the sign-up button is clicked
                .addOnCompleteListener {
                    if (!it.isSuccessful) return@addOnCompleteListener
                    Log.d(
                        "RegisterMeActivity",
                        "Successfully created user: ${it.result?.user?.uid}"
                    )
                    // notification alert of successful login
                    Toast.makeText(
                        this,
                        "Successfully created user:${it.result?.user?.uid}",
                        Toast.LENGTH_SHORT
                    ).show()

                }
                //Check for failure of sign-up action when the sign-up button is clicked
                .addOnFailureListener {
                    Log.d("RegisterMeActivity", "Failed to create user: ${it.message}")
                //notification alert of failed sign-up process
                    Toast.makeText(this, "Failed to create user: ${it.message}", Toast.LENGTH_SHORT)
                        .show()
                }

        }
        // call the login activity when the LOGIn button is clicked
        login_view.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

    }
}
