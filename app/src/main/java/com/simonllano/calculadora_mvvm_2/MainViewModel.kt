package com.simonllano.calculadora_mvvm_2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val result_operation: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }
    fun result_operator(number1: Double,number2:Double,operador:Int){
        var answer:Double=0.0
        when(operador){
            1-> answer=number1+number2
            2-> answer=number1-number2
            3-> answer=number1*number2
            4-> answer=number1/number2
        }
        result_operation.value=answer
    }

}