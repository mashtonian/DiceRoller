package com.mashton.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countUpButton = findViewById<Button>(R.id.count_up_button)
        countUpButton.setOnClickListener {countUp()}

        val resetButton = findViewById<Button>(R.id.reset_button)
        resetButton.setOnClickListener {reset()}
    }
    
    private var currentCount = 1
    private val diceSize = 6

    private fun reset() {
        currentCount = 1
        setRollImage(currentCount)
    }
    
    private fun countUp() {
        if (currentCount != diceSize)
        {
            currentCount += 1
            setRollImage(currentCount)
        }
    }

    private fun rollDice() {
        currentCount = (1..diceSize).random()
        setRollImage(currentCount)
    }

    private fun setRollImage(rollNumber: Int) {
        val diceImage = findViewById<ImageView>(R.id.dice_image)
        val drawableResource = when (rollNumber)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }
}