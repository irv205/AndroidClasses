package com.irv205.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.irv205.testproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

//    lateinit var edCorreo : EditText
//    lateinit var btn : Button

    lateinit var correo: EditText
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        edCorreo = findViewById(R.id.edCorreo)
//        btn = findViewById(R.id.btnLogin)

        correo = binding.edCorreo

        btn = binding.btnLogin

        btn.setOnClickListener {
            Toast.makeText(this, correo.text, Toast.LENGTH_LONG).show()
        }

//        btn.setOnClickListener {
//            Toast.makeText(this, edCorreo.text, Toast.LENGTH_LONG).show()
//        }

    }
}