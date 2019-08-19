package com.example.helloworld

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private val MAX_COUNT = 6
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton : Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDie() }

        val countUpButton : Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener { countUp() }

        val resetButton : Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }
    }

    private fun rollDie()
    {
        count = Random().nextInt(MAX_COUNT) + 1

        setText("Number is $count")
        Toast.makeText(this, (R.string.result_random), Toast.LENGTH_SHORT).show()
    }

    private fun countUp()
    {
        if (count == MAX_COUNT)
        {
            Toast.makeText(this, (R.string.result_max), Toast.LENGTH_SHORT).show()
            return
        }
        count++

        setText("Number is $count")
        Toast.makeText(this, (R.string.result_up), Toast.LENGTH_SHORT).show()
    }

    private fun reset()
    {
        count = 0
        setText(getString(R.string.greeting))
    }

    private fun setText(text : String)
    {
        val resultText : TextView = findViewById(R.id.result_text)
        resultText.text = text
    }
}
