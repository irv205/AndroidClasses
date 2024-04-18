package com.irv205.testproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.irv205.testproject.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

    private var _binding: FragmentBlankBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!


    private var name: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         name = requireArguments().getString("NAME","NO name")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlankBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.textView3.text = name

        binding.btnExplicit.setOnClickListener {
            explicitIntent()
        }
        binding.btnImplicit.setOnClickListener {
            implicitIntent()
        }

        binding.btnFragment.setOnClickListener {
            //TODO Navigate to user fragment
            requireActivity().supportFragmentManager
                .beginTransaction()
                .add( R.id.container,BlankFragment())
                .commit()
        }

    }

    private fun explicitIntent() {

        val text = binding.etMain
        val intent = Intent(requireActivity(), UserActivity::class.java).apply {
            putExtra("inputText", text.text.toString())
        }
        startActivity(intent)
    }

    private fun implicitIntent(){
        val url = "https://www.google.com/"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}