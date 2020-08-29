package com.mashton.android.diceroller

import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Test

import org.junit.Assert.*

class DiceTests {

    private val testDice = Dice()

    @Test
    fun rolledDiceProducesNumberBetweenOneAndSix() {
        testDice.roll()
        assertTrue(testDice.value in (1..6))
    }

    @Test
    fun diceRolledAHundredTimesAlwaysBetweenOneAndSix() {
        var assertionStatus = true
        for (x in 1..100) {
            testDice.roll()
            assertionStatus = testDice.value in (1..6)
        }
        assertTrue(assertionStatus)
    }

    @Test
    fun clearDiceSetsValueToZero() {
        testDice.roll()
        testDice.clear()
        assertEquals(0, testDice.value)
    }

    @Test
    fun increaseDiceDoesNothingOnUnrolledDice() {
        testDice.value = 0
        testDice.increase()
        assertEquals(0, testDice.value)
    }

    @Test
    fun increaseDiceDoesNothingOnDiceWithValueSix() {
        testDice.value = 6
        testDice.increase()
        assertEquals(6, testDice.value)
    }

    @Test
    fun increaseDiceIncreasesByOneForOneToFive() {
        var assertionStatus = true
        for (x in 1..5) {
            testDice.value = x
            testDice.increase()
            assertionStatus = (x + 1 == testDice.value)
        }
        assertTrue(assertionStatus)
    }
}
