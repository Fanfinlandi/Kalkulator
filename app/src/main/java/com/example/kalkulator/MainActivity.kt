package com.example.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private var currentInput: String = ""
    private var operator: String = ""
    private var firstOperand: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editTextText2)
   
        // Przypisanie przycisków
        findViewById<Button>(R.id.button0).setOnClickListener { appendToInput("0") }
        findViewById<Button>(R.id.button1).setOnClickListener { appendToInput("1") }
        findViewById<Button>(R.id.button2).setOnClickListener { appendToInput("2") }
        findViewById<Button>(R.id.button3).setOnClickListener { appendToInput("3") }
        findViewById<Button>(R.id.button4).setOnClickListener { appendToInput("4") }
        findViewById<Button>(R.id.button5).setOnClickListener { appendToInput("5") }
        findViewById<Button>(R.id.button6).setOnClickListener { appendToInput("6") }
        findViewById<Button>(R.id.button7).setOnClickListener { appendToInput("7") }
        findViewById<Button>(R.id.button8).setOnClickListener { appendToInput("8") }
        findViewById<Button>(R.id.button9).setOnClickListener { appendToInput("9") }
        findViewById<Button>(R.id.button21).setOnClickListener { clearInput() }
        findViewById<Button>(R.id.buttonAdd).setOnClickListener { setOperator("+") }
        findViewById<Button>(R.id.buttonSub).setOnClickListener { setOperator("-") }
        findViewById<Button>(R.id.buttonMul).setOnClickListener { setOperator("*") }
        findViewById<Button>(R.id.buttonDiv).setOnClickListener { setOperator("/") }

        findViewById<Button>(R.id.buttonEq).setOnClickListener { calculate() }
    }

    private fun appendToInput(value: String) {
        currentInput += value
        editText.setText(currentInput)
    }

    private fun setOperator(op: String) {
        if (currentInput.isNotEmpty()) {
            firstOperand = currentInput.toDouble()
            operator = op
            currentInput = ""
            editText.setText("")
        }
    }

    private fun calculate() {
        if (currentInput.isNotEmpty() && operator.isNotEmpty()) {
            val secondOperand = currentInput.toDouble()
            val result = when (operator) {
                "+" -> firstOperand + secondOperand
                "-" -> firstOperand - secondOperand
                "*" -> firstOperand * secondOperand
                "/" -> firstOperand / secondOperand
                else -> 0.0
            }


            editText.setText(if (result % 1.0 == 0.0) result.toInt().toString() else result.toString())
            currentInput = ""
            operator = ""
        }
    }
    private fun clearInput() {
        currentInput = "" // Wyczyść aktualny input
        editText.setText("") // Wyczyść wyświetlacz
    }
}
