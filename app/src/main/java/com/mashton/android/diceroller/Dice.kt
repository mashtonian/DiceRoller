package com.mashton.android.diceroller

class Dice {
    var value = 0

    fun roll() {
        value = (1..6).random()
    }

    fun clear() {
        value = 0
    }

    val imageResource
        get() = when (value) {
            0 -> R.drawable.empty_dice
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }


}