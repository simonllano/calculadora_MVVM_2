package com.simonllano.calculadora_mvvm_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import com.simonllano.calculadora_mvvm_2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

        private lateinit var mainBinding: ActivityMainBinding
        private lateinit var mainViewModel: MainViewModel

        /*lateinit var view_result_text: TextView*/
        private var operacion: Int = 0
        private var reset: Int = 0
        private var number1: Double = 0.0
        private var number2: Double = 0.0

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            mainBinding = ActivityMainBinding.inflate(layoutInflater)
            val view = mainBinding.root
            setContentView(view)
            mainBinding.viewResultText.setText("")

            mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

            val resultObserve = Observer<Double> { result_operation ->
                mainBinding.viewResultText.setText(result_operation.toString())
            }
            mainViewModel.result_operation.observe(this, resultObserve)

            /*creamos los clickListener para las operaciones */
            mainBinding.buttonAdd.setOnClickListener {
                operacion = 1
                number1 = mainBinding.viewResultText.text.toString().toDouble()
                mainBinding.viewResultText.setText("")

            }
            mainBinding.buttonSubtract.setOnClickListener {
                operacion = 2
                number1 = mainBinding.viewResultText.text.toString().toDouble()
                mainBinding.viewResultText.setText("")
            }
            mainBinding.buttonMultiply.setOnClickListener {
                operacion = 3
                number1 = mainBinding.viewResultText.text.toString().toDouble()
                mainBinding.viewResultText.setText("")
            }
            mainBinding.buttonDivide.setOnClickListener {
                operacion = 4
                number1 = mainBinding.viewResultText.text.toString().toDouble()
                mainBinding.viewResultText.setText("")
            }
            mainBinding.buttonSame.setOnClickListener {
                number2 = mainBinding.viewResultText.text.toString().toDouble()
                mainViewModel.result_operator(number1, number2, operacion)
                reset = 1
            }
        }

        fun press_digitos(view: View) {
            if (reset == 1) {
                mainBinding.viewResultText.setText("") //profe, esto es para limpiar la pantalla cuando termine una operación y quiera seguir realizando operaciones
                reset = 0
            }

            val numero = mainBinding.viewResultText.text.toString()
            when (view.id) {
                R.id.button_0 -> mainBinding.viewResultText.setText(numero + "0")
                R.id.button_1 -> mainBinding.viewResultText.setText(numero + "1")
                R.id.button_2 -> mainBinding.viewResultText.setText(numero + "2")
                R.id.button_3 -> mainBinding.viewResultText.setText(numero + "3")
                R.id.button_4 -> mainBinding.viewResultText.setText(numero + "4")
                R.id.button_5 -> mainBinding.viewResultText.setText(numero + "5")
                R.id.button_6 -> mainBinding.viewResultText.setText(numero + "6")
                R.id.button_7 -> mainBinding.viewResultText.setText(numero + "7")
                R.id.button_8 -> mainBinding.viewResultText.setText(numero + "8")
                R.id.button_9 -> mainBinding.viewResultText.setText(numero + "9")
                R.id.button_point -> mainBinding.viewResultText.setText(numero + ".")
            }
        }
    }
