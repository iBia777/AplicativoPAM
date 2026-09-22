package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aula_id)

        val notaP1 = findViewById<EditText>(R.id.ednota1)
        val notaP2 = findViewById<EditText>(R.id.ednota2)
        val resultadoMedia = findViewById<TextView>(R.id.txtResultado)
        val botaoMedia = findViewById<Button>(R.id.btnCalcular)

        botaoMedia.setOnClickListener {
            val p1 = notaP1.text.toString().toFloatOrNull()
            val p2 = notaP2.text.toString().toFloatOrNull()

            if (p1 != null && p2 != null) {
                val media = (p1 + p2) / 2
                resultadoMedia.text = "Média é: %.2f".format(media)
            } else {
                resultadoMedia.text = "Digite as duas notas!"
            }
        }

        val peso = findViewById<EditText>(R.id.edPeso)
        val altura = findViewById<EditText>(R.id.edAltura)
        val resultadoImc = findViewById<TextView>(R.id.txtResultadoIMC)
        val botaoImc = findViewById<Button>(R.id.btnCalcularIMC)

        botaoImc.setOnClickListener {
            val pesoValor = peso.text.toString().toFloatOrNull()
            val alturaValor = altura.text.toString().toFloatOrNull()

            if (pesoValor != null && alturaValor != null && alturaValor > 0f) {
                val imc = pesoValor / (alturaValor * alturaValor)
                resultadoImc.text = String.format("Seu IMC é: %.2f", imc)
            } else {
                resultadoImc.text = "Digite peso e altura válidos!"
            }
        }
    }
}