package com.example.calculatorapplication

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    var isNewOperator = true
    lateinit var edt1: EditText
    var operator = "+"
    var initialNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.editText)

    }

    fun numberEvent(view: View) {
        if (isNewOperator)
            edt1.setText("")
        isNewOperator = false

        var number = edt1.text.toString()

        when (view.id) {
            R.id.b1 -> number += "1"
            R.id.b2 -> number += "2"
            R.id.b3 -> number += "3"
            R.id.b4 -> number += "4"
            R.id.b5 -> number += "5"
            R.id.b6 -> number += "6"
            R.id.b7 -> number += "7"
            R.id.b8 -> number += "8"
            R.id.b9 -> number += "9"
            R.id.b0 -> number += "0"
            R.id.b00 -> number += "00"
            R.id.bpoint -> number += "."
        }
        edt1.setText(number)
    }

    fun operatorEvent(view: View) {
        isNewOperator = true
        initialNumber = edt1.text.toString()

        when (view.id) {
            R.id.multiply -> operator = "*"
            R.id.subtract -> operator = "-"
            R.id.divide -> operator = "/"
            R.id.add -> operator = "+"
        }
        edt1.setText(operator)
    }

    fun equalEvent(view: View) {
        val newNumber = edt1.text.toString()
        var output = 0.0

        when (operator) {
            "+" -> output = initialNumber.toDouble() + newNumber.toDouble()
            "/" -> output = initialNumber.toDouble() / newNumber.toDouble()
            "*" -> output = initialNumber.toDouble() * newNumber.toDouble()
            "-" -> output = initialNumber.toDouble() - newNumber.toDouble()
        }
        edt1.setText(output.toString())
    }

    fun clearEvent(view: View) {
        edt1.setText("0")
        isNewOperator = true
    }

    fun percentEvent(view: View) {
        val num = edt1.text.toString().toDouble() / 100
        edt1.setText(num.toString())
        isNewOperator = true
    }
}