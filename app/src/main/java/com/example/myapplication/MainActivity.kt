package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R.id.editValor

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.aula_id)

        val botao = findViewById<Button>(R.id.btnProxima)

        val texto = findViewById<EditText>(editValor)

        botao.text = "Novo texto"

        botao.setOnClickListener {

            botao.text = texto.text


            }
    }
}
