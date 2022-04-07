package com.alvaro.lab1part1alv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class BMIdatanw : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmidatanw)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.bmidata_menu, menu);
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


            else -> super.onOptionsItemSelected(item)
        }
    }
}