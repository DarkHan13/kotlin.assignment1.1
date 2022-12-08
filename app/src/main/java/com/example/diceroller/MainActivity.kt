package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // my code below
        val rollButton: Button = findViewById(R.id.button2)
        rollButton.setOnClickListener { rollDice() }

        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6)
        val image: ImageView = findViewById(R.id.imageView)
        val diceRollNumber = dice.roll()
        val drawableResource = when(diceRollNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        image.setImageResource(drawableResource)
        image.contentDescription = diceRollNumber.toString()
    }


}

class Dice(private val numSides : Int) {
    fun roll() : Int {
        return (1..numSides).random()
    }
}