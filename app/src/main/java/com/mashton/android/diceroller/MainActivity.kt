package com.mashton.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countUpButton = findViewById<Button>(R.id.count_up_button)
        countUpButton.setOnClickListener {countUp()}
    }

    private var currentCount = 0

    private fun countUp() {
        if (currentCount != 6)
        {
            currentCount += 1
            setRollText(currentCount)
        }

    }

    private fun rollDice() {
        //Toast.makeText(this, getString(R.string.button_clicked_toast_text), Toast.LENGTH_SHORT).show()

        currentCount = (1..6).random()
        setRollText(currentCount)
    }

    private fun setRollText(randomInt: Int) {
        val resultText = findViewById<TextView>(R.id.result_text)
        resultText.text = randomInt.toString()
    }
}