package com.example.a13032024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Tela2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)

        var bundle = intent.extras
        val data = bundle?.getString("digitado")
        findViewById<TextView>(R.id.txtRetornoT2).text = data

        findViewById<Button>(R.id.btEnviarT2).setOnClickListener(View.OnClickListener {

            val intentRet = Intent(this, MainActivity::class.java)

            val strRetorno = findViewById<EditText>(R.id.edAEnviarT2).text.toString()

            intentRet.putExtra("digitado", strRetorno )
            setResult(RESULT_OK, intentRet)

            finish()
        })
    }
}