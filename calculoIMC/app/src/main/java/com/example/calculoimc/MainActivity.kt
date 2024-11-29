/**
 * Autores: Rafael Moreira - 23333
 *          Vitor Henrique - 23340
 */

package com.example.calculoimc

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtAltura = findViewById<EditText>(R.id.edAltura)
        var txtPeso = findViewById<EditText>(R.id.edPeso)
        var btnCalcular = findViewById<Button>(R.id.btnCalculate)
        var txtResposta = findViewById<TextView>(R.id.idResposta)
        var imageView : ImageView = findViewById(R.id.imageView)

        fun calcular(peso: Double, Altura: Double) {
            var altura : Double = (Altura * Altura);
            val imc: Double = peso / altura;
            if (imc < 18.5) {
                txtResposta.setText("Abaixo do Peso")
                imageView.setColorFilter(Color.RED)
            } else if (imc <= 24.9) {
                txtResposta.setText("Peso Ideal")
                imageView.setColorFilter(Color.GREEN)
            } else if (imc <= 29.9) {
                txtResposta.setText("Levemente Acima do Peso")
                imageView.setColorFilter(Color.YELLOW)
            } else if (imc <= 34.9) {
                txtResposta.setText("Obesidade Grau I")
                imageView.setColorFilter(Color.rgb(255, 140, 0))
            } else if (imc <= 39.9) {
                txtResposta.setText("Obesidade Grau II")
                imageView.setColorFilter(Color.rgb(255, 69, 0))
            } else if (imc >= 40) {
                txtResposta.setText("Obesidade Grau III")
                imageView.setColorFilter(Color.rgb(255, 0, 0))
            }
        }

        btnCalcular.setOnClickListener(View.OnClickListener {
            var editAltura = txtAltura.text.toString().toDouble()
            var editPeso = txtPeso.text.toString().toDouble()
            calcular(editPeso, editAltura)
        })
    }
}