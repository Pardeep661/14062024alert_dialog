package com.pardeep.a14_06_2024_alert_dialog

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding

class MainActivity : AppCompatActivity() {
    //declaration of variable
    var et_text :EditText? = null
    var cal_button :Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // initilization oof var
        et_text = findViewById(R.id.editText)
        cal_button = findViewById(R.id.button)

        cal_button?.setOnClickListener() {
            if (et_text?.text?.trim().isNullOrEmpty()) {
                et_text?.error = "Please enter the number"
            } else {
                var et_data = et_text?.text?.toString()
                var alert_dialog = AlertDialog.Builder(this@MainActivity).apply {
                    setTitle("hello")
                    setMessage("press Add button to addtion of ${et_data}\npress Subs button to substract ${et_data}\npress Reset button to reset 0")
                    setPositiveButton("Add"){Dialog,which ->
                        Toast.makeText(this@MainActivity, "Add button is pressed", Toast.LENGTH_SHORT).show()
                        var int_data = et_data?.toInt()
                        var added_data = int_data?.plus(int_data)
                        et_text?.setText(added_data.toString())
                    }
                    // negative button
                    setNegativeButton("Subs"){Dialog,which ->
                        Toast.makeText(this@MainActivity, "Subs button is pressed", Toast.LENGTH_SHORT).show()
                        var int_data = et_data?.toInt()
                        var Subs_data = int_data?.minus(int_data)
                        et_text?.setText(Subs_data.toString())
                    }

                    setNeutralButton("Reset"){Dialog,which ->
                        Toast.makeText(this@MainActivity, "Reset button is pressed", Toast.LENGTH_SHORT).show()
                        et_text?.setText("0")
                    }

                }.show()

            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}