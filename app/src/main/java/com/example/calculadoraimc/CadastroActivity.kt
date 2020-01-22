package com.example.calculadoraimc


import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_main.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)


        val minhaPreferencia = getSharedPreferences("minha-preferencia", Context.MODE_PRIVATE)


        val meuEditor = minhaPreferencia.edit()


        btnRegister.setOnClickListener {
            val nome = edtName.text.toString().trim()
            val email = edtEmail.text.toString().trim().toLowerCase()
            val senha = edtSenha.text.toString().trim()

            if(nome.isEmpty() || email.isEmpty() || senha.isEmpty()){
                Toast.makeText(this@CadastroActivity, "Por favor, preencha todos os campos!", Toast.LENGTH_LONG).show()
            }else {
                meuEditor.putString("nome", nome).apply()
                meuEditor.putString("email", email).apply()
                meuEditor.putString("senha", senha).apply()

                AlertDialog.Builder(this@CadastroActivity)
                    .setTitle("Sucesso")
                    .setMessage("Usuário cadastrado com sucesso")
                    .setPositiveButton("OK") {_,_ ->
                       onBackPressed()
                    }
                    .create()
                    .show()
            }
        }

    }
}
