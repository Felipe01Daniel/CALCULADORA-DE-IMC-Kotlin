package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Spinner Lista de Sexo
        val listaSexo = arrayListOf("     Selecione o Sexo", "Feminino", "Masculino")
        val adapterSexo = ArrayAdapter(this@MainActivity, R.layout.spinner_item,listaSexo)
        adapterSexo.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spnSexo.adapter = adapterSexo


        //Button Calcular
        btnCalcular.setOnClickListener {
            startActivity(Intent(this@MainActivity, ResultadoActivity::class.java))
        }

        //Button Tabela
        btnTabela.setOnClickListener {
            startActivity(Intent(this@MainActivity, TabelaActivity::class.java))
        }
    }
}
