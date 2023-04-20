package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    private var tvInput :TextView?=null
    var lastNumeric : Boolean = false
    var lastDot :Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        tvInput= findViewById(R.id.tvInput)
    }
        fun onDigitClick(view: View){
//            Toast.makeText(this,"button clicked",Toast.LENGTH_LONG).show()
            tvInput?.append((view as Button).text)
            lastNumeric = true
            lastDot=false
        }
    fun onClear(view: View){
        tvInput?.text = ""
    }
    fun onDecimalPoint(view: View){
    if(lastNumeric && !lastDot){
            tvInput?.append(".")
        lastNumeric = false
        lastDot = true
      }
    }
    fun onOperator(view: View){
        tvInput?.text?.let {
            if(lastNumeric && !isOperatorAdded(it.toString())){
                tvInput?.append((view as Button).text)
                lastNumeric=false
                lastDot=false
            }
        }
    }


    private fun isOperatorAdded(value:String):Boolean{
        return if(value.startsWith("-")){
            false
        }
        else{
            value.contains("/")
                    || value.contains("*")
                    ||value.contains("+")
                    ||value.contains("-")
        }
    }
}
