package com.example.a06_03_2024

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.a06_03_2024.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnColor.setOnClickListener(View.OnClickListener {
            binding.lbTitulo.setTextColor(Color.RED)
        })

        binding.btnTela2.setOnClickListener(View.OnClickListener {

            val telaInfoIntent = Intent(this,TelaInfoActivity::class.java)

            telaInfoIntent.putExtra("titulo","Info Vesp Rule´s")

            startActivity(telaInfoIntent)

        })
    }
}