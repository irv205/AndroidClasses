package com.irv205.testproject.presentation.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.irv205.testproject.R
import com.irv205.testproject.domain.model.RegisterUserDomain

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    private fun registro() {

//        viewModel.validateRegistro(
//            RegisterUserDomain(
//                binding.etMail.text.toString(),
//                binding.etMail.text.toString(),
//                binding.etMail.text.toString(),
//                binding.etMail.text.toString(),
//            )
//        )
    }
}