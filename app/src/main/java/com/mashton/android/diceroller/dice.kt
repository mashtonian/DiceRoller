package com.mashton.android.diceroller

class dice {
    var value = 0

    fun roll()
    {
        value = (1..6).random()
    }

    fun reset(){
        value = 0
    }
}