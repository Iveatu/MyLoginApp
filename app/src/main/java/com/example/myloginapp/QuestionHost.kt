package com.example.myloginapp


import java.util.ArrayList

class QuestionHost {
    // declares a mutablelist array to store the quiz questions
    internal var items: MutableList<QuestAnswer> = ArrayList()
// this function contains the questions. it will be called by the QuestionfunActivity class
    fun setQuestions() {
        items.add(
            QuestAnswer(
                "Q1 :The Earth has three moons.",
                false
            )
        )
        items.add(
            QuestAnswer(
                "Q2: The Capital of Canada is Regina.",
                false
            )
        )
        items.add(
            QuestAnswer(
                "Q3: Microsoft developed Android.",
                false
            )
        )
        items.add(
            QuestAnswer(
                "Q4: Is Google the developer of ExoPlayer Library.",
                true
            )
        )
        items.add(
            QuestAnswer(
                " Q5: The colour of Nigeria flag is Green, White, Green.",
                true
            )
        )
        items.add(
            QuestAnswer(
                "Q6: The President of USA at 2004 was Donald Trump.",
                false
            )
        )
        items.add(
            QuestAnswer(
                "Q7: 1024 kilobytes makes one Megabyte.",
                true
            )
        )
        items.add(
            QuestAnswer(
                "Q8: The result of mixing blue and yellow is green.",
                true
            )
        )
        items.add(
            QuestAnswer(
                "Q9: WalMart is located in Nigeria.",
                false
            )
        )
        items.add(
            QuestAnswer(
                "Q10: Is 25 + 25 = 50?",
                true
            )
        )


    }


}
