package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var seekPeso : SeekBar
    lateinit var textPeso : TextView
    lateinit var seekAltura : SeekBar
    lateinit var textAltura : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Spinner Lista de Sexo
        val listaSexo = arrayListOf("     Selecione o Sexo", "Feminino", "Masculino")
        val adapterSexo = ArrayAdapter(this@MainActivity, R.layout.spinner_item,listaSexo)
        adapterSexo.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spnSexo.adapter = adapterSexo


        //SeekBar PESO
        seekPeso = findViewById(R.id.seekBarPeso) as SeekBar
        textPeso = findViewById(R.id.txtPeso) as TextView
        seekPeso.max = 200

        seekPeso.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textPeso.text = progress.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        //SeekBar Altura
        seekAltura = findViewById(R.id.seekBarAltura) as SeekBar
        textAltura = findViewById(R.id.txtAltura) as TextView
        seekAltura.max = 200

        seekAltura.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textAltura.text = progress.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        //Button Calcular
        btnCalcular.setOnClickListener {
            var peso = txtPeso.text.toString().trim()
            var altura = txtAltura.text.toString().trim()
            var pesoResultado = peso.toDouble()
            var alturaResultado = altura.toDouble()

            if (peso == "0" || altura == "0"){
                Toast.makeText(this@MainActivity, "Voce precisa selecionar altura e peso", Toast.LENGTH_LONG).show()
            }else{
                var calcImc = pesoResultado / (alturaResultado * alturaResultado)
                var calcimcr = calcImc * 10000

                AlertDialog.Builder(this@MainActivity)
                    .setTitle("Reulstado")
                    .setMessage("${calcimcr.toInt()}")
                    .setPositiveButton("Ok"){_,_ ->

                    }
                    .create()
                    .show()
            }
        }

        //Button Resultado
        btnResultado.setOnClickListener {
            startActivity(Intent(this@MainActivity, ResultadoActivity::class.java))
        }

        //Button Tabela
        btnTabela.setOnClickListener {
            startActivity(Intent(this@MainActivity, TabelaActivity::class.java))
        }
    }
}
