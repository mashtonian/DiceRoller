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
        diceImageList = listOf(diceOneImage, diceTwoImage)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val resetButton = findViewById<Button>(R.id.clear_button)
        resetButton.setOnClickListener { reset() }
    }

    lateinit var diceOneImage: ImageView
    lateinit var diceTwoImage: ImageView
    lateinit var diceImageList: List<ImageView>

    private val diceOne = Dice()
    private val diceTwo = Dice()
    private val diceList = listOf(diceOne, diceTwo)

    private fun reset() {
        diceList.map { it.reset() }
        setDiceImages()
    }

    private fun rollDice() {
        diceList.map { it.roll() }
        setDiceImages()
    }

    private fun setDiceImages() {
        diceImageList.zip(diceList)
        { image, dice -> image.setImageResource((dice.imageResource)) }
    }

}