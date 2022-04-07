package com.alvaro.lab1part1alv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class ImperialUnits : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imperial_units)

        val infotxt2=findViewById<TextView>(R.id.infoTxt2)
        val infobmi2=findViewById<TextView>(R.id.bmires2)

        infotxt2.visibility= View.INVISIBLE
        infobmi2.visibility= View.INVISIBLE
        val mbutton2= findViewById<Button>(R.id.btn2)
        mbutton2.setOnClickListener {

            val weightim=findViewById<EditText>(R.id.weightlbsttxt)
            var weightimp:Double=weightim.text.toString().toDouble()

            val heightim=findViewById<EditText>(R.id.heightfttxt)
            var heightimp:Double=heightim.text.toString().toDouble()

            val heightin=findViewById<EditText>(R.id.heightinttxt)
            var heightinp:Double=heightin.text.toString().toDouble()



            var heig:Double=((heightimp*12)+heightinp)
            var bmi2:Double=((weightimp/(heig*heig))*703)

            Log.i( "msg", "weight is ${weightimp}, height is ${heig}. BMI is ${bmi2}")

            infotxt2.visibility= View.VISIBLE
            infotxt2.text="${String.format("%.3f",bmi2)}"
            infobmi2.visibility= View.VISIBLE
            infobmi2.text="${bmiresult2(bmi2)}"



        }


    }


    fun openBMIdata() {
        val k = Intent(applicationContext, BMIdata::class.java)
        startActivity(k)
    }
    fun openBMIdatanw() {
        val l = Intent(applicationContext, BMIdatanw::class.java)
        startActivity(l)
    }
    fun openBMIdataow() {
        val i = Intent(applicationContext, BMIdataow::class.java)
        startActivity(i)
    }
    fun openBMIdatao() {
        val d = Intent(applicationContext, BMIdatao::class.java)
        startActivity(d)
    }



    fun bmiresult2(bmi2:Double):String{
        var sol=""
        var color=0
        if(bmi2<18.5){
            sol="Underweight"
            color=R.color.Underweight
            val dtextview = findViewById<TextView>(R.id.infoTxt2)
            dtextview.setOnClickListener {
                openBMIdata();
            }
            dtextview.setTextColor(ContextCompat.getColor(this,color))
        }
        else if(bmi2>18.5 && bmi2<24.9){
            sol="Normal Weight"
            color=R.color.NormalWeight

            val dtextview = findViewById<TextView>(R.id.infoTxt2)
            dtextview.setOnClickListener {
                openBMIdatanw();
            }
            dtextview.setTextColor(ContextCompat.getColor(this,color))
        }else if (bmi2>24.9 && bmi2<29.9) {
            sol = "Overweight"
            color=R.color.Overweight

            val dtextview = findViewById<TextView>(R.id.infoTxt2)
            dtextview.setOnClickListener {
                openBMIdataow();
            }
            dtextview.setTextColor(ContextCompat.getColor(this,color))
        }else {
            sol = "Obese"
            color=R.color.Obese

            val dtextview = findViewById<TextView>(R.id.infoTxt2)
            dtextview.setOnClickListener {
                openBMIdatao();

            }
            dtextview.setTextColor(ContextCompat.getColor(this,color))
        }


        return sol
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.secondary_menu, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.Metric_Units -> {
                Toast.makeText(applicationContext, "Changed to Metric Units", Toast.LENGTH_LONG)
                    .show()
                val i = Intent(applicationContext, MainActivity::class.java)
                startActivity(i)
                return true
            }
            R.id.Author_Info -> {
                Toast.makeText(applicationContext, "Author information", Toast.LENGTH_LONG).show()
                val j = Intent(applicationContext, AuthorInfo::class.java)
                startActivity(j)
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }



}
