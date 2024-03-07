package com.irv205.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.irv205.testproject.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inputText = intent.getStringExtra("inputText")
        binding.edMain.text = inputText

    }
}