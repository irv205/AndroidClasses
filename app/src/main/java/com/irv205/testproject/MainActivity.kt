package com.irv205.testproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.irv205.testproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //comentario



        binding.btnExplicit.setOnClickListener {
            explicitIntent()
        }
        binding.btnImplicit.setOnClickListener {
            implicitIntent()
        }


    }

    private fun explicitIntent() {

        val text = binding.etMain
        val intent = Intent(this, UserActivity::class.java).apply {
            putExtra("inputText", text.text.toString())
        }
        startActivity(intent)
    }

    private fun implicitIntent(){
        val url = "https://www.google.com/"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }


}