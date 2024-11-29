package com.example.button02vesp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var txtDescr: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtDescr = findViewById((R.id.txtDescription))

        val btnF1 = findViewById<Button>(R.id.btnPhrase1)
        btnF1.setOnclickListener(this)

        findViewById<Button>(R.id.btnPhrase2).setOnClickListener(this)
        findViewById<Button>(R.id.btnClean).setOnClickListener(this)
    }

    override fun onClick(v: View?){
        when{
            v?.id == R.id.btnPhrase1 -> txtDescr.text = "Frase 1"
            v?.id == R.id.btnPhrase2 -> txtDescr.text = "Frase 2"
            v?.id == R.id.btnClean -> txtDescr.text = "Frase 1"

        }

    }

}