package com.alvaro.lab1part1alv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

// here is the implementation that I tried to use for the
// history as well as for storing the values. My main issue is that I dont know why
// the preference manager doesnt work properly
class History : AppCompatActivity() {
    private val key ="Mykey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)


        //obtain preference manager
        val prefs= PreferenceManager.getDefaultSharedPreferences(this)

        // saves the preferences
        // we store the value obtained. Not a string but the BMI result
        val btnsave = findViewById<Button>(R.id.btnsave)
        btnsave.setOnClickListener {
            val editor= prefs.edit()
            editor.putString(key,"Value") // here is where the bmi value should go
            editor.apply()
            showalert("Value Stored")
        }
        //shows the preferences
        val btnshow = findViewById<Button>(R.id.btnshow)
        btnshow.setOnClickListener {
            val mypref =prefs.getString(key,"No value") // this one show the value stored in our history
            showalert("mypref")
        }
        //deletes the preferences
        val btndelete = findViewById<Button>(R.id.btndelete)
        btndelete.setOnClickListener {
            val editor= prefs.edit()
            editor.remove(key)
            editor.apply()
            showalert("Value Deleted") // this one erases our history
        }
    }
    // here we show alerts for each of the previous buttons
    private fun showalert(message: String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("My preferences")
        builder.setMessage(message)
        val dialog = builder.create()
        dialog.show()
    }
    // implementation of the options menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.history_menu, menu);
        return true;
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.Metric_Units -> {
                Toast.makeText(applicationContext, "Changed to Metric Units", Toast.LENGTH_LONG).show()
                val i = Intent(applicationContext, MainActivity::class.java)
                startActivity(i)
                return true
            }
            R.id.Imperial_Units -> {
                Toast.makeText(applicationContext, "Changed to Imperial Units", Toast.LENGTH_LONG).show()
                val j = Intent(applicationContext, ImperialUnits::class.java)
                startActivity(j)
                return true
            }
            R.id.Author_Info -> {
                Toast.makeText(applicationContext, "Changed to Author Info", Toast.LENGTH_LONG).show()
                val k = Intent(applicationContext, AuthorInfo::class.java)
                startActivity(k)
                return true
            }


            else -> super.onOptionsItemSelected(item)
        }
    }
}