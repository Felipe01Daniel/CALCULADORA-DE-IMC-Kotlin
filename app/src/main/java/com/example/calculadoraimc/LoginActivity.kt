package com.example.calculadoraimc

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val minhaPreferencia = getSharedPreferences("minha-preferencia", Context.MODE_PRIVATE)

        btnEntrar.setOnClickListener {
            val usuario = edtName.text.toString().trim()
            val senha = edtSenha.text.toString().trim()

            val recuperarNome = minhaPreferencia.getString("email", "Erro no SharedPreference")
            val recuperarSenha = minhaPreferencia.getString("senha", "Erro no 404")

            if (usuario.isNotEmpty()) {
                if (senha.isNotEmpty()) {
                    if (usuario == recuperarNome) {
                        if (senha == recuperarSenha) {
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        } else {
                            edtSenha.setText("")
                            Toast.makeText(this@LoginActivity, "Senha incorreta", Toast.LENGTH_LONG)
                                .show()
                        }
                    } else {
                        edtName.setText("")
                        edtSenha.setText("")
                        Toast.makeText(this@LoginActivity, "Usuario incorreto", Toast.LENGTH_LONG)
                            .show()
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "Digite uma senha", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this@LoginActivity, "Digite um usuário", Toast.LENGTH_LONG).show()
            }


        }
        btnCadastro.setOnClickListener {
            startActivity(Intent(this@LoginActivity, CadastroActivity::class.java))
        }
    }
}
