package com.example.a06_03_2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.a06_03_2024.databinding.ActivityMainBinding
import com.example.a06_03_2024.databinding.ActivityTelaInfoBinding
import java.util.zip.Inflater

class TelaInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTelaInfoBinding.inflate(layoutInflater)
        val tela = binding.root
        setContentView(tela)

        val bundle : Bundle? = intent.extras
        val titulo : String? = bundle?.getString("titulo")

        binding.lbTexto2.text = titulo

        binding.btnReturn.setOnClickListener(View.OnClickListener {
            finish()
        })
    }


}