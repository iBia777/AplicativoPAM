package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trabalho)

        val etNumeroDobro = findViewById<EditText>(R.id.etNumeroDobro)
        val btnDobro = findViewById<Button>(R.id.btnDobro)
        val tvResultadoDobro = findViewById<TextView>(R.id.tvResultadoDobro)

        btnDobro.setOnClickListener {
            val numero = etNumeroDobro.text.toString().toIntOrNull()
            if (numero != null) {
                val dobro = numero * 2
                tvResultadoDobro.text = dobro.toString()
            } else {
                tvResultadoDobro.text = "Digite um número válido"
            }
        }

        val etIdadeDias = findViewById<EditText>(R.id.etIdadeDias)
        val btnIdadeDias = findViewById<Button>(R.id.btnIdadeDias)
        val tvResultadoDias = findViewById<TextView>(R.id.tvResultadoDias)

        btnIdadeDias.setOnClickListener {
            val idade = etIdadeDias.text.toString().toIntOrNull()
            if (idade != null) {
                val dias = idade * 365
                tvResultadoDias.text = "Você já viveu aproximadamente $dias dias"
            } else {
                tvResultadoDias.text = "Digite uma idade válida"
            }
        }

        val etValorConta = findViewById<EditText>(R.id.etValorConta)
        val btnGorjeta = findViewById<Button>(R.id.btnGorjeta)
        val tvResultadoGorjeta = findViewById<TextView>(R.id.tvResultadoGorjeta)

        btnGorjeta.setOnClickListener {
            val valorConta = etValorConta.text.toString().toDoubleOrNull()
            if (valorConta != null) {
                val gorjeta = valorConta * 0.10
                tvResultadoGorjeta.text = String.format(Locale.US, "%.2f", gorjeta)
            } else {
                tvResultadoGorjeta.text = "Digite um valor válido"
            }
        }

        val etValorDolar = findViewById<EditText>(R.id.etValorDolar)
        val btnConverterMoeda = findViewById<Button>(R.id.btnConverterMoeda)
        val tvResultadoMoeda = findViewById<TextView>(R.id.tvResultadoMoeda)

        btnConverterMoeda.setOnClickListener {
            val valorDolar = etValorDolar.text.toString().toDoubleOrNull()
            if (valorDolar != null) {
                val valorReal = valorDolar * 5.50
                tvResultadoMoeda.text = String.format(Locale.US, "R$ %.2f", valorReal)
            } else {
                tvResultadoMoeda.text = "Digite um valor válido"
            }
        }

        val etNota1 = findViewById<EditText>(R.id.etNota1)
        val etNota2 = findViewById<EditText>(R.id.etNota2)
        val btnCalcularMedia = findViewById<Button>(R.id.btnCalcularMedia)
        val tvResultadoMedia = findViewById<TextView>(R.id.tvResultadoMedia)

        btnCalcularMedia.setOnClickListener {
            val nota1 = etNota1.text.toString().toDoubleOrNull()
            val nota2 = etNota2.text.toString().toDoubleOrNull()
            if (nota1 != null && nota2 != null) {
                val media = (nota1 + nota2) / 2
                tvResultadoMedia.text = media.toString()
            } else {
                tvResultadoMedia.text = "Preencha as duas notas com valores válidos"
            }
        }

        val etIdadeCategoria = findViewById<EditText>(R.id.etIdadeCategoria)
        val btnClassificarIdade = findViewById<Button>(R.id.btnClassificarIdade)
        val tvResultadoCategoria = findViewById<TextView>(R.id.tvResultadoCategoria)

        btnClassificarIdade.setOnClickListener {
            val idade = etIdadeCategoria.text.toString().toIntOrNull()
            if (idade != null) {
                val categoria = if (idade < 12) {
                    "Criança"
                } else if (idade in 12..17) {
                    "Adolescente"
                } else if (idade in 18..59) {
                    "Adulto"
                } else {
                    "Idoso"
                }
                tvResultadoCategoria.text = categoria
            } else {
                tvResultadoCategoria.text = "Digite uma idade válida"
            }
        }

        val etValorCompra = findViewById<EditText>(R.id.etValorCompra)
        val btnCalcularDesconto = findViewById<Button>(R.id.btnCalcularDesconto)
        val tvResultadoDesconto = findViewById<TextView>(R.id.tvResultadoDesconto)

        btnCalcularDesconto.setOnClickListener {
            val valorCompra = etValorCompra.text.toString().toDoubleOrNull()
            if (valorCompra != null) {
                val percentualDesconto = if (valorCompra < 100.0) {
                    0
                } else if (valorCompra < 300.0) {
                    5
                } else if (valorCompra < 500.0) {
                    10
                } else {
                    15
                }

                val valorFinal = valorCompra * (1 - percentualDesconto / 100.0)
                tvResultadoDesconto.text = String.format(
                    Locale.US,
                    "Desconto: %d%% - Total: R$ %.2f",
                    percentualDesconto,
                    valorFinal
                )
            } else {
                tvResultadoDesconto.text = "Digite um valor válido"
            }
        }
    }
}