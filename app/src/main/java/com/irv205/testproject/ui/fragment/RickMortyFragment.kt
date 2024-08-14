package com.irv205.testproject.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.irv205.testproject.databinding.FragmentBlankBinding
import com.irv205.testproject.ui.adapter.RickMortyAdapter
import com.irv205.testproject.ui.viewmodel.RickMortyViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RickMortyFragment : Fragment() {

    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!!
    private val adapterRM by lazy { RickMortyAdapter() }
    private val viewModel by viewModels<RickMortyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

       _binding = FragmentBlankBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.rvRickAndMorty.apply {
            adapter = adapterRM
            layoutManager = LinearLayoutManager(requireContext())
        }

        initializeObservers()

        adapterRM.click { name ->
            printToastName(name)
        }

        viewModel.fetchCharacters()

    }

    private fun printToastName(name: String){
        Toast.makeText(requireContext(), name, Toast.LENGTH_SHORT).show()
    }

    private fun initializeObservers(){
        viewModel.character.observe(viewLifecycleOwner){ characters ->
            adapterRM.submitList(characters)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}