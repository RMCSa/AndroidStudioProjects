package com.example.button01vesp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    fun btnClick(v: View?){
        when(v?.id) {
            R.id.btnPhrase1 -> println("Frase 1")
            R.id.btnPhrase2 -> println("Frase 2")
            else -> println("Nenhum")
        }
        println(v?.id)
    }

    fun btnClear(v: View?){
        println("Limpando...")
        txtClear.text = ""
    }
}