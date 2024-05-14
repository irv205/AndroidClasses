package com.irv205.testproject.login.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.irv205.testproject.R
import com.irv205.testproject.databinding.FragmentLoginBinding
import com.irv205.testproject.login.presenter.LoginPresenter
import com.irv205.testproject.login.presenter.LoginPresenterImp
import com.irv205.testproject.model.User

class LoginFragment : Fragment(), LoginView {

    private lateinit var binding: FragmentLoginBinding
    private var presenter: LoginPresenter = LoginPresenterImp(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeListeners()
    }


    private fun initializeListeners(){
        binding.btnLogin.setOnClickListener {
            val username = binding.edtUser.text.toString()
            val password = binding.edtPassword.text.toString()
            presenter.login(username, password)
        }

        binding.btnAdd.setOnClickListener {
            val username = binding.edtUserNameForm.text.toString()
            val password = binding.edtPasswordForm.text.toString()
            presenter.addUser(username, password)
        }
    }

    override fun success(message: String) {
        findNavController().navigate(R.id.action_blankFragment_to_secondFragment)
    }

    override fun error(message: String) {
        Toast.makeText( requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showUsers(users: List<User>) {
        binding.tvUsers.text = users.toString()
    }

    override fun showError(message: String) {
        Toast.makeText( requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}