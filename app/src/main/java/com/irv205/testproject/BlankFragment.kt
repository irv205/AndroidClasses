package com.irv205.testproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.irv205.testproject.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

    private lateinit var binding: FragmentBlankBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(layoutInflater)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeListeners()
    }


    private fun initializeListeners(){
        binding.btnExplicit.setOnClickListener {
            explicitIntent()
        }
        binding.btnImplicit.setOnClickListener {
            implicitIntent()
        }

        binding.navigateButton.setOnClickListener {
            val song = Song("Test",12, 1, "Corridos")
            val destination = BlankFragmentDirections.actionBlankFragmentToSecondFragment(song)
            findNavController().navigate(destination)
        }

    }

    private fun explicitIntent() {

//        val text = binding.etMain
//        val intent = Intent(this, UserActivity::class.java).apply {
//            putExtra("inputText", text.text.toString())
//        }
//        startActivity(intent)
    }

    private fun implicitIntent(){
        val url = "https://www.google.com/"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

}