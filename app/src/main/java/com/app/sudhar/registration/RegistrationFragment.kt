package com.app.sudhar.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.sudhar.R
import com.app.sudhar.databinding.FragmentRegistrationBinding


class RegistrationFragment : Fragment() {
    private lateinit var binding: FragmentRegistrationBinding
    private var dest = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding = FragmentRegistrationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init(){
        initSetViews()
        initClickListeners()
    }

    private fun initSetViews() {

    }

    private fun initClickListeners()=binding.apply{
        grpRadio.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.coalBtn -> {
                    dest = "coal"
                }
                R.id.govtBtn -> {
                    dest = "govt"
                }
            }
        }
        btnSave.setOnClickListener {
            when(dest){
                "coal"->findNavController().navigate(R.id.action_registration_to_coalMineEmployeeFragment)
                "govt"->findNavController().navigate(R.id.action_registration_to_governmentEmployerRegistrationFragment)
                ""->Toast.makeText(requireContext(), "Please select any one option", Toast.LENGTH_SHORT).show()
            }
        }
    }

}