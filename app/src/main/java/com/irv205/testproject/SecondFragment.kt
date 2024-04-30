package com.irv205.testproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.irv205.testproject.databinding.FragmentSecondBinding

class SecondFragment: Fragment() {

    private var _binding : FragmentSecondBinding? = null
    private val binding get() = _binding!!
    //private val navArgs by navArgs<Blan>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.infoTextView.text = requireArguments().getString("user_name")

        binding.infoTextView.text = requireArguments().getParcelable<Song>("song").toString()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}