package com.irv205.testproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.irv205.testproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    lateinit var text: TextView
//    lateinit var btn: Button

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val url = "https://www.google.com/"
//        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

        binding.btnExplicit.setOnClickListener {
            explicitIntent()
        }
        binding.btnImplicit.setOnClickListener {
            implicitIntent()
        }

//        text = findViewById(R.id.edMain)
//        btn = findViewById(R.id.btnMain)

//        text.text = "Test texto"
//        text.textSize = 25f

//        btn.text = "Click Perron"
//        btn.setOnClickListener {
//            text.text = "Hubo un click"
//        }

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