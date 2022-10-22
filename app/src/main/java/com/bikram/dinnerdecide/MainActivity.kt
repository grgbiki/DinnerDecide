package com.bikram.dinnerdecide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val items = arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val title = findViewById<TextView>(R.id.title)
        val addFoodEditText = findViewById<EditText>(R.id.add_food_edit_text)
        val addFoodButton = findViewById<Button>(R.id.add_food_button)
        val decideButton = findViewById<Button>(R.id.decide_button)

        addFoodButton.setOnClickListener {
            val customFood = addFoodEditText.text.toString()

            if(customFood.isNotEmpty()){
                items.add(customFood)
                Toast.makeText(this, "Food Item Added", Toast.LENGTH_LONG).show()
                addFoodEditText.text.clear()
            }
        }

        decideButton.setOnClickListener{
            val randomIndex = Random.nextInt(items.size)
            title.text = items[randomIndex]
        }
    }
}