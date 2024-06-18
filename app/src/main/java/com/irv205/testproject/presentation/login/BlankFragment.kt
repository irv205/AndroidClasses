package com.irv205.testproject.presentation.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.irv205.testproject.databinding.FragmentBlankBinding
import com.irv205.testproject.domain.model.Song

class BlankFragment : Fragment() {

    private lateinit var binding: FragmentBlankBinding
    private val viewModel : LoginViewModel by viewModels()

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
        ///observer()

    }

//    private fun observer() {
//        viewModel.character.observe(viewLifecycleOwner) {
//            binding.tvCharacter.text = it.name
//        }
//    }


    private fun initializeListeners(){
        binding.btnExplicit.setOnClickListener {
            explicitIntent()
        }
        binding.btnImplicit.setOnClickListener {
            implicitIntent()
        }

        binding.navigateButton.setOnClickListener {
            val song = Song("Test",12, 1, "Corridos")
            //val destination = BlankFragmentDirections.actionBlankFragmentToSecondFragment(song)
            //findNavController().navigate(destination)
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