package com.example.a13032024

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import android.app.AlertDialog
import android.content.DialogInterface
import android.widget.Toast
import androidx.core.app.AppLaunchChecker

class MainActivity : AppCompatActivity() {
    private lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edtTextoAenviar = findViewById<EditText>(R.id.edAEnviar)
        var txtResposta = findViewById<TextView>(R.id.txtRetorno)
        var btnEnviar = findViewById<Button>(R.id.btEnviar)

        launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK){
                var data = result.data
                txtResposta.text = data?.getStringExtra("digitado")
            }
        }

        fun exibirDialogoOpcao(){
            var Tela2Intent = Intent(this, Tela2Activity::class.java)
            val str: String = edtTextoAenviar.text.toString()
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Confirmar envio?")
            builder.setItems(arrayOf("SIM", "CANCELAR")) { dialog, resposta ->
                when (resposta) {
                    0 -> {
                        Toast.makeText(this, "Enviado", Toast.LENGTH_SHORT).show()
                        Tela2Intent.putExtra("digitado", str )
                        launcher.launch(Tela2Intent)
                    }
                    1 -> {
                        Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()

                    }
                }
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }

        btnEnviar.setOnClickListener(View.OnClickListener {
            var Tela2Intent = Intent(this, Tela2Activity::class.java)
            val str: String = edtTextoAenviar.text.toString()
            if (str.uppercase().contains("ASA")){
                exibirDialogoOpcao()
            }
            else{
                Tela2Intent.putExtra("digitado", str )
                launcher.launch(Tela2Intent)
            }
        })

    }

}