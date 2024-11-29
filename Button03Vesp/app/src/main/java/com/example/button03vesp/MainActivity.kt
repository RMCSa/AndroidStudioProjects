package com.example.button03vesp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtDescr = findViewById<Button>(R.id.txtDesciption)

        val btnF1 = findViewById<Button>(R.id.btnPhrase1)
        btnF1.setOnClickListener(object: View.OnClickListener{


        })
    }
}