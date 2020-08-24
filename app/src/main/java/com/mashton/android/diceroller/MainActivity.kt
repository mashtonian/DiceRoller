package com.mashton.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceOneImage = findViewById<ImageView>(R.id.dice_one_image)
        diceTwoImage = findViewById<ImageView>(R.id.dice_two_image)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val resetButton = findViewById<Button>(R.id.reset_button)
        resetButton.setOnClickListener {reset()}
    }

    lateinit var diceOneImage : ImageView
    lateinit var diceTwoImage : ImageView

    private var diceOneCurrentCount = 0
    private var diceTwoCurrentCount = 0

    private fun reset() {
        diceOneCurrentCount = 0
        diceTwoCurrentCount = 0
        setDiceImages(diceOneCurrentCount, diceTwoCurrentCount)
    }
    

    private fun rollDice() {
        diceOneCurrentCount = (1..6).random()
        diceTwoCurrentCount = (1..6).random()
        setDiceImages(diceOneCurrentCount, diceTwoCurrentCount)
    }

    private fun setDiceImages(diceOneNumber: Int, diceTwoNumber: Int) {

        diceOneImage.setImageResource(getDiceDrawableResource(diceOneNumber))
        diceTwoImage.setImageResource(getDiceDrawableResource(diceTwoNumber))
    }

    private fun getDiceDrawableResource(number: Int): Int
    {
        return when (number)
        {
            0 -> R.drawable.empty_dice
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}