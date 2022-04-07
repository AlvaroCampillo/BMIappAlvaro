package com.alvaro.lab1part1alv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// we define the class for the viewModel
class BmiViewModel : ViewModel() {
    private var iBmi = MutableLiveData<Double>()
    val bmi: LiveData<Double> = iBmi

// set the BMI counter
    fun countBmi(weighted: Double, heighted: Double){
        var bmi: Double = ((weighted / (heighted * heighted)) * 10000)
        iBmi.value = bmi
    }

}

