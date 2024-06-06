package com.example.calculatorprojectyou

import android.icu.util.UniversalTimeScale.toLong
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatorprojectyou.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    // here we create an array to manage last index of input box is operator  or number
    val arrOperator = arrayListOf("+" , "-", "*" , "/")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // here we apply setonClickListener

        binding.btn0.setOnClickListener {
            setExpression("0" , false)
        }

        binding.btn1.setOnClickListener {
            setExpression("1" , false)
        }

        binding.btn00.setOnClickListener {
            setExpression("00" , false)
        }

        binding.btn2.setOnClickListener {
            setExpression("2" , false)
        }

        binding.btn3.setOnClickListener {
            setExpression("3" , false)
        }

        binding.btn4.setOnClickListener {
            setExpression("4" , false)
        }

        binding.btn5.setOnClickListener {
            setExpression("5" , false)
        }

        binding.btn6.setOnClickListener {
            setExpression("6" , false)
        }

        binding.btn7.setOnClickListener {
            setExpression("7" , false)
        }

        binding.btn8.setOnClickListener {
            setExpression("8" , false)
        }

        binding.btn9.setOnClickListener {
            setExpression("9" , false)
        }
        binding.btnDot.setOnClickListener {
            setExpression("." , true)
        }
        binding.btnAdd.setOnClickListener {
            setExpression("+" , true)
        }

        binding.btnMul.setOnClickListener {
            setExpression("*" , true)
        }

        binding.btnSub.setOnClickListener {
            setExpression("-" , true)
        }

        binding.btnDiv.setOnClickListener {
            setExpression("/" ,  true)
        }

        binding.btnPer.setOnClickListener {
            setExpression("%" , true)
        }

        // this is equal button
        binding.btnEql.setOnClickListener {
            val text = binding.inputBox.text.toString()
            val expression = ExpressionBuilder(text).build()
            val result = expression.evaluate()
            binding.outputBox.text = result.toString()

        }

        // here we apply logic for clear the text
        binding.btnAc.setOnClickListener {
            binding.inputBox.editableText.clear()
            binding.outputBox.text =""

        }

        // here we apply logic for delete button

        binding.btnDel.setOnClickListener {
           binding.inputBox.editableText.clear()
            binding.outputBox.text = ""
        }

        // here we apply logic for find Square of the number
        binding.btnSquare.setOnClickListener {
            // here we apply logic for find square
            val numberSq =  binding.inputBox.text.toString()
            val Square = numberSq.toLong()
            val SQResult = Square * Square ;
            binding.outputBox.text = SQResult.toString()
        }

        // here we apply logic find Cube of the number
        binding.btnCube.setOnClickListener {

            val numberCu = binding.inputBox.text.toString()
            val Cube = numberCu.toLong()
            val CUResult = Cube * Cube * Cube;
            binding.outputBox.text = CUResult.toString()
        }

        // here we apply logic find Factorial of the number

        binding.btnFactorial.setOnClickListener {

            val numberFac = binding.inputBox.text.toString().toLong()
            if (numberFac < 0){
                binding.outputBox.text = "Can't Find"
            }
            else {
                var fact : Long = 1
                for (i in 1..numberFac){
                    fact *= i
                }
                binding.outputBox.text = fact.toString()
            }
        }
    }
    // Here we create2 function for set text
    private fun setExpression(expression: String , operator : Boolean) {

        val text = binding.inputBox.text.toString()

        if (operator && arrOperator.contains(text[text.length-1].toString())){
            Toast.makeText(this, "Only One operator assign", Toast.LENGTH_SHORT).show()
        }else{
            binding.inputBox.text.append(expression)


        }

    }
}

