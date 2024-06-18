package com.irv205.testproject.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.irv205.testproject.R
import com.irv205.testproject.databinding.FragmentLoginBinding
import kotlin.math.log

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        login()
        observer()
    }

    private fun login() {
        binding.btnLogin.setOnClickListener {
            viewModel.validateUser(binding.etMail.text.toString())
            //Toast.makeText(context, binding.etMail.text.toString(), Toast.LENGTH_LONG).show()
        }
    }

    private fun observer() {

        viewModel.user.observe(viewLifecycleOwner) {
            when(it){
                true -> {
                    val destination = LoginFragmentDirections.actionLoginFragmentToSecondFragment()
                    findNavController().navigate(destination)
                    Toast.makeText(context, "Existe", Toast.LENGTH_LONG).show()
                }
                false -> Toast.makeText(context, "No existe", Toast.LENGTH_LONG).show()
            }
        }

        viewModel.login.observe(viewLifecycleOwner) {
            when(it) {
                true -> TODO()
                false -> TODO()
            }
        }

        viewModel.register.observe(viewLifecycleOwner) {
            when(it){
                true -> TODO()
                false -> TODO()
            }
        }
    }
}