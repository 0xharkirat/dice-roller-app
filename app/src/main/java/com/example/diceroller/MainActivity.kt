package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create the rollButton variable for the Button
        val rollButton: Button = findViewById(R.id.button)

        // Create the click listener method for the rollButton
        rollButton.setOnClickListener {

            // Call the rollDice function
            rollDice()
        }

        // Call the rollDice function when the app starts.
        rollDice()

    }

    // Define the rollDice function
    private fun rollDice() {

        // Create the Variable name dice and assign the Dice class to it
        val dice = Dice(6)

        // Call the roll function of Dice class and assign it to diceRoll variable
        val diceRoll = dice.roll()

        // Create the diceImage variable for the ImageView
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

// Define the Dice class and the input
class Dice(private val numSides: Int) {

    // Define the roll function and output
    fun roll(): Int {

        // Return the random number when roll function is called
        return (1..numSides).random()
    }
}