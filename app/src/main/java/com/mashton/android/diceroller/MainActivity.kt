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

    private fun countUp() {
        val resultText = findViewById<TextView>(R.id.result_text)
        when (resultText.toString())
        {
            "Hello World!" -> resultText.text = "1"

        }
    }

    private fun rollDice() {
        //Toast.makeText(this, getString(R.string.button_clicked_toast_text), Toast.LENGTH_SHORT).show()

        val randomInt = (1..6).random()
        val resultText = findViewById<TextView>(R.id.result_text)
        resultText.text = randomInt.toString()
    }
}