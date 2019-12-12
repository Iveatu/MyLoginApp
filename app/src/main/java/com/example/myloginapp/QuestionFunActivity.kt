package com.example.myloginapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_question_fun.*

class QuestionFunActivity : AppCompatActivity() {
    // declaration of all the private variables for the question class
    private var questionHost: QuestionHost? = null
    private var totalQuestions: List<QuestAnswer>? = null
    private var clickAnswer = false
    private var questionNum = 0
    private var resultScore = 0
   // this is called to save and recover state information for this activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_fun)
        // this calls the class that stores the questions for the quiz
        questionHost = QuestionHost()
        questionHost!!.setQuestions()
        totalQuestions = questionHost!!.items

        // this call the next question function
        nextQuest()
        // this is activated when the Yes button is clicked
        btn_positive.setOnClickListener {
            clickAnswer = true
            confirmAnswer(clickAnswer)
        }
        //this is activated when the No button is clicked
        btn_negative.setOnClickListener {
            clickAnswer = false
            confirmAnswer(clickAnswer)
        }
    }
// This function is called to verify whether the quiz answer choice made is right or wrong
    private fun confirmAnswer(pickedAnswer: Boolean) {
        val rightAnswer = totalQuestions!![questionNum].answer1
        if (rightAnswer == pickedAnswer) {
            resultScore += 1
            Toast.makeText(this, "Right Choice", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Wrong Choice", Toast.LENGTH_SHORT).show()
        }
        questionNum += 1
    // This call the next question function
        nextQuest()
    }
    // this function is called to scroll from one question to the other as long as the maximum question limit is not exceeded
    private fun nextQuest() {
        if (questionNum <= totalQuestions!!.size - 1) {
            en_question.text = totalQuestions!![questionNum].questionText1
            updateInterface()
        } else {
            // this function here because the question maximum count as been exceeded
            updateInterface()
            // this launches an alert dialog box for user to make a choice to quit or repeat quiz questions
            AlertDialog.Builder(this)
                // these are the components of the Alert Dialog prompt.
                .setTitle("Splendid!")
                .setMessage("You've attempted all the questions. Do you want to try again?")
                    // sets the quiz to repeat when the Attemt again option is clicked
                .setPositiveButton("Attempt again") { dialog, which -> startOver() }
                    //make the quiz to end and launch the final activity in this quiz app
                .setNegativeButton("Quit") {dialog,which->
                    val intent = Intent(this, ResultMainActivity::class.java)
                    // show congratulation Activity
                    startActivity(intent)
                }
                .show()

        }

    }
    // this is the function called to update the question counter, result and the progress bar features of the question activity each time a question is attempted
    private fun updateInterface() {
        en_quest_num.text = (questionNum + 1).toString() + "/" + totalQuestions!!.size
        en_score.text = "Score: ${resultScore}"
        progBar.progress = questionNum + 1
    }
// this is the function that is called to repeat the quiz exercise when the attempt quiz again option is clicked
    private fun startOver() {
        resultScore = 0
        questionNum = 0
        nextQuest()
    }
}

