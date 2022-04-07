package com.alvaro.lab1part1alv

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: BmiViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//implementation of the bmi viewmodel
        viewModel= ViewModelProvider(this).get(BmiViewModel::class.java)
        viewModel.bmi.observe(this){ bmi ->
            // declaration of values
            val infotxt = findViewById<TextView>(R.id.infoTxt)
            val infobmi = findViewById<TextView>(R.id.bmires)
            // make results visible
            infotxt.visibility = View.VISIBLE
            infotxt.text = "${String.format("%.3f", bmi)}"
            infobmi.visibility = View.VISIBLE
            infobmi.text = "${bmiresult(bmi)}"
        }
// we get the values
        val infotxt = findViewById<TextView>(R.id.infoTxt)
        val infobmi = findViewById<TextView>(R.id.bmires)
        //make result textfields invisible
        infotxt.visibility = View.INVISIBLE
        infobmi.visibility = View.INVISIBLE

        // button implementation
        val mbutton = findViewById<Button>(R.id.btn)
        mbutton.setOnClickListener {

            val weightedit = findViewById<EditText>(R.id.weightimttxt)
            var weighted: Double = weightedit.text.toString().toDouble()

            val heightedit = findViewById<EditText>(R.id.heightimttxt)
            var heighted: Double = heightedit.text.toString().toDouble()

            viewModel.countBmi(weighted, heighted)
            //Log.i("msg", "weight is ${weighted}, height is ${heighted}. BMI is ${bmi}")
        }


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.Imperial_Units -> {
                Toast.makeText(applicationContext, "Changed to Imperial Units", Toast.LENGTH_LONG)
                    .show()
                val i = Intent(applicationContext, ImperialUnits::class.java)
                startActivity(i)
                return true
            }
            R.id.Author_Info -> {
                Toast.makeText(applicationContext, "Author information", Toast.LENGTH_LONG).show()
                val j = Intent(applicationContext, AuthorInfo::class.java)
                startActivity(j)
                return true
            }
            R.id.History -> {
                Toast.makeText(applicationContext, "History Data", Toast.LENGTH_LONG).show()
                val p = Intent(applicationContext, History::class.java)
                startActivity(p)
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
    //implementation for each screen for the various body state
    // underweight
    fun openBMIdata() {
        val k = Intent(applicationContext, BMIdata::class.java)
        startActivity(k)

    }
    //normal weight
    fun openBMIdatanw() {
        val l = Intent(applicationContext, BMIdatanw::class.java)
        startActivity(l)

    }
    //over weight
    fun openBMIdataow() {
        val t = Intent(applicationContext, BMIdataow::class.java)
        startActivity(t)

    }
    //obese
    fun openBMIdatao() {
        val w = Intent(applicationContext, BMIdatao::class.java)
        startActivity(w)

    }

// here we state wether our result is in one category or another
    fun bmiresult(bmi: Double): String {
        var sol = ""
        var color= 0
        if (bmi < 18.5) {
            sol = "Underweight"
            color = R.color.Underweight
            val dtextview = findViewById<TextView>(R.id.infoTxt)
            dtextview.setOnClickListener {
                openBMIdata();
            }
            dtextview.setTextColor(ContextCompat.getColor(this,color))


        } else if (bmi > 18.5 && bmi < 24.9) {
            sol = "Normal Weight"
            color= R.color.NormalWeight
            val dtextview = findViewById<TextView>(R.id.infoTxt)
            dtextview.setOnClickListener {
                openBMIdatanw();
            }
            dtextview.setTextColor(ContextCompat.getColor(this,color))

        } else if (bmi > 24.9 && bmi < 29.9) {
            sol ="Overweight"
            color=R.color.Overweight

            val dtextview = findViewById<TextView>(R.id.infoTxt)
            dtextview.setOnClickListener {
                openBMIdataow();
            }
            dtextview.setTextColor(ContextCompat.getColor(this,color))

        } else {
            sol = "Obese"
            color=R.color.Obese
            val dtextview = findViewById<TextView>(R.id.infoTxt)
            dtextview.setOnClickListener {
                openBMIdatao();
            }
            dtextview.setTextColor(ContextCompat.getColor(this,color))

        }

        return sol

    }


}









