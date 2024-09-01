package com.app.sudhar.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.sudhar.R
import com.app.sudhar.databinding.FragmentGovernmentEmployerRegistrationBinding
import com.app.sudhar.databinding.FragmentRegistrationBinding

class GovernmentEmployerRegistrationFragment : Fragment() {
    private lateinit var binding: FragmentGovernmentEmployerRegistrationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGovernmentEmployerRegistrationBinding.inflate(inflater)
        return binding.root
    }
}