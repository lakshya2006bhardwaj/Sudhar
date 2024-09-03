package com.app.sudhar.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.app.sudhar.R
import com.app.sudhar.databinding.FragmentCalculatorBinding
import com.app.sudhar.databinding.FragmentRegistrationBinding

class CalculatorFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding
    private var dest = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentCalculatorBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initSetView()
        initClickListener()
    }

    private fun initSetView(){

    }

    private fun initClickListener()=binding.apply{
        grpRadio.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.surfaceBtn -> {
                    dest = "surface"
                }
                R.id.undergroundBtn -> {
                    dest = "underground"
                }
            }
        }

        btnSave.setOnClickListener {
            when(dest){
                "surface"->findNavController().navigate(R.id.action_calculatorFragment_to_surfaceMiningCalculatorFragment)
                "underground"->findNavController().navigate(R.id.action_calculatorFragment_to_undergroundMiningCalculatorFragment)
                ""-> Toast.makeText(requireContext(), "Please select any one option", Toast.LENGTH_SHORT).show()
            }
        }

    }



}

