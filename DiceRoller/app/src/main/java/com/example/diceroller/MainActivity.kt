package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    /**
     * This activity allows the user to roll a dice and view the result
     * on the screen.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        // Do a dice roll when the app runs
        rollDice()
    }

    private fun rollDice() {
        /**
         * Roll the dice and update the screen with the result.
         */
        val dice = Dice(6)
        // This up here creates a dice with 6 sides
        val diceRoll = dice.roll()
        // this show us the result of rolling the dice in our app
        val diceImage: ImageView = findViewById(R.id.imageView1)
        // this up here finds the imageView in the Layout
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        } // the code up here determine which drawable resource id to use depending on the dice roll
        diceImage.setImageResource(drawableResource)
        // Update the ImageView with the correct resource id
        diceImage.contentDescription = diceRoll.toString()
        // Updates the content description
        // This the same thing for another dice with the same button
        val dice2 = Dice(6)
        val dice2roll = dice2.roll()
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        val drawableResource2 = when (dice2roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage2.setImageResource(drawableResource2)
        diceImage2.contentDescription = dice2roll.toString()
    }

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}