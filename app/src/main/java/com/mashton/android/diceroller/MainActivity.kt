package com.mashton.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImageList = listOf(
            findViewById<ImageView>(R.id.dice_one_image),
            findViewById<ImageView>(R.id.dice_two_image)
        )

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { performDiceAction(Dice::roll) }

        val resetButton = findViewById<Button>(R.id.clear_button)
        resetButton.setOnClickListener { performDiceAction(Dice::reset) }
    }

    private lateinit var diceImageList: List<ImageView>
    private val diceList = listOf(Dice(), Dice())

    private fun performDiceAction(action: Dice.() -> Unit) {
        diceList.map { it.action() }
        diceImageList.zip(diceList)
        { image, dice -> image.setImageResource((dice.imageResource)) }
    }
}