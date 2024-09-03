package com.app.sudhar.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.sudhar.R
import com.app.sudhar.databinding.FragmentUndergroundMiningCalculatorBinding

class UndergroundMiningCalculatorFragment : Fragment() {
    private lateinit var binding: FragmentUndergroundMiningCalculatorBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUndergroundMiningCalculatorBinding.inflate(inflater)
        return binding.root
    }
}