package com.irv205.testproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import com.irv205.testproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val fragment =  BlankFragment()
        fragment.arguments = bundleOf("NAME" to "Irving")

        supportFragmentManager
            .beginTransaction()
            .add( R.id.container,fragment)
            .commit()


    }


    private fun createVoiceNote() {
    
    }
    
    private fun Test() {
        
    }


}
