package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var seekPeso : SeekBar
    lateinit var textPeso : TextView
    lateinit var seekAltura : SeekBar
    lateinit var textAltura : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Spinner Lista de Sexo
        val listaSexo = arrayListOf("Selecione o Sexo", "Feminino", "Masculino")
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
            val sexo = spnSexo.selectedItem

            if (peso == "0" || altura == "0" || sexo == "Selecione o Sexo"){
                Toast.makeText(this@MainActivity, "Voce precisa selecionar altura, peso e sexo", Toast.LENGTH_LONG).show()
            }else{
                var calcImc = pesoResultado / (alturaResultado * alturaResultado)
                var calcimcr = calcImc * 10000
                var message = ""


                if (sexo == "Feminino"){
                    AlertDialog.Builder(this@MainActivity)
                        .setTitle("Resultado")
                        .setMessage(
                            "Seu IMC: ${calcimcr.toInt()}" +
                                    "\n Classificação: $message" +
                                    "\n ${if (calcimcr < 19) {
                                        "Você esta abaixo do peso"
                                    } else if (calcimcr <= 23 && calcimcr >= 19) {
                                        "Você esta no peso Normal"
                                    } else if (calcimcr <= 28 && calcimcr >= 24) {
                                        "Obesidade Leve"
                                    } else if (calcimcr <= 38 && calcimcr >= 29) {
                                        "Obesidade Moderada"
                                    } else {
                                        "Obesidade Morbida"
                                    }}"
                        )

                        .setPositiveButton("Ok") { _, _ ->

                        }
                        .create()
                        .show()

                }else {

                    AlertDialog.Builder(this@MainActivity)
                        .setTitle("Resultado")
                        .setMessage(
                            "$sexo " +
                                    "\nSeu IMC: ${calcimcr.toInt()}" +
                                    "\n Classificação: $message" +
                                    "\n ${if (calcimcr < 20) {
                                        "Você esta abaixo do peso"
                                    } else if (calcimcr <= 24 || calcimcr >= 20) {
                                        "Você esta no peso Normal"
                                    } else if (calcimcr >= 29 || calcimcr >= 25) {
                                        "Obesidade Leve"
                                    } else if (calcimcr >= 39 || calcimcr >= 30) {
                                        "Obesidade Moderada"
                                    } else {
                                        "Obesidade Morbida"
                                    }}"
                        )

                        .setPositiveButton("Ok") { _, _ ->

                        }
                        .create()
                        .show()
                }
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
