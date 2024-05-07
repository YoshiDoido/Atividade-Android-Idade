package com.example.app_02_2024_04_30

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val txtAno = findViewById<EditText>(R.id.txtAno)
        val txtMes = findViewById<EditText>(R.id.txtMes)
        val txtDia = findViewById<EditText>(R.id.txtDia)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val txtSexo = findViewById<TextView>(R.id.txtSexo)
        val btnConverter = findViewById<Button>(R.id.btn_Converter)
        val radioMasculino = findViewById<RadioButton>(R.id.radio_masculino)
        val radioFeminino = findViewById<RadioButton>(R.id.radio_feminino)

        btnConverter.setOnClickListener {
            if (txtAno.text.isEmpty()) {
                txtAno.error = "Digite a quantidade de ano(s)"
            } else if (txtMes.text.isEmpty()) {
                txtMes.error = "Digite a quantidade de mes(es)"
            } else if (txtDia.text.isEmpty()) {
                txtDia.error = "Digite a quantidade de dia(s)"
            } else {

                //Entrada de dados
                val ano = txtAno.text.toString().toInt()
                val mes = txtMes.text.toString().toInt()
                val dia = txtDia.text.toString().toInt()

                //Processamento de dados
                val resultado = (ano * 365) + (mes * 30) + dia
                val menorDeIdade = 6575

                if(resultado < menorDeIdade) {
                    txtResultado.text = "Você é menor de idade! \nA sua idade em dias é: $resultado"
                } else {
                    txtResultado.text = "Você é maior de idade! \nA sua idade em dias é: $resultado"
                }

            }
        }

        radioMasculino.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                txtSexo.text = "Você é do sexo masculino e deve se alistar no exército!"
            }
        }

        radioFeminino.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                txtSexo.text = "Você é do sexo feminino e não precisa se alistar no exército"
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}