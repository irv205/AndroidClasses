package com.irv205.testproject.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.irv205.testproject.databinding.FragmentLoginBinding
import com.irv205.testproject.domain.model.RegisterUserDomain

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
            viewModel.validateLogin(
                binding.etMail.text.toString(),
                binding.edPassword.text.toString()
            )
            //viewModel.testCoroutine()
        }
        binding.buttonCancel.setOnClickListener {
            viewModel.cancelCoroutine()
        }

    }

    private fun observer() {
        viewModel.loginState.observe(viewLifecycleOwner) { loginstate ->
            when(loginstate){
                LoginState.Default -> { }
                is LoginState.Login -> {
                    val destination = LoginFragmentDirections.actionLoginFragmentToSecondFragment()
                    findNavController().navigate(destination)
                    Toast.makeText(context, "Login", Toast.LENGTH_LONG).show()
                }
                LoginState.Register -> {
                    val destination = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
                    findNavController().navigate(destination)
                    Toast.makeText(context, "Registro", Toast.LENGTH_LONG).show()
                }
                LoginState.Error -> {
                    Toast.makeText(context, "No existe", Toast.LENGTH_LONG).show()
                }

                LoginState.MailError -> {
                    Toast.makeText(context, "Mail incorrecto", Toast.LENGTH_LONG).show()
                }
                LoginState.PasswordError -> {
                    Toast.makeText(context, "Password incorrecto", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}