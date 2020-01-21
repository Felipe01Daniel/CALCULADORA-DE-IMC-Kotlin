package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener {
            startActivity(Intent(this@MainActivity, ResultadoActivity::class.java))
        }

        btnTabela.setOnClickListener {
            startActivity(Intent(this@MainActivity, TabelaActivity::class.java))
        }
    }
}
