package com.app.sudhar.registration

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.app.sudhar.R
import com.app.sudhar.databinding.FragmentGovernmentEmployerRegistrationBinding
import com.app.sudhar.databinding.FragmentRegistrationBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class GovernmentEmployerRegistrationFragment : Fragment() {
    private lateinit var binding: FragmentGovernmentEmployerRegistrationBinding
    private var currStep = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGovernmentEmployerRegistrationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initSetView()
        initClickListner()
    }

    private fun initSetView()=binding.apply{
        step1View.visibility=View.VISIBLE
        step2View.visibility=View.GONE
        step3View.visibility=View.GONE
    }

    private fun initClickListner()=binding.apply{

        etDOB.setOnClickListener{
            showDatePickerDialog()
        }

        btnNext.setOnClickListener{
            if (etFullName.text.isEmpty()){
                Toast.makeText(requireContext(), "Please enter Full Name", Toast.LENGTH_SHORT).show()
            } else if (etDOB.text.isEmpty()){
                Toast.makeText(requireContext(), "Please select DOB", Toast.LENGTH_SHORT).show()
            } else if (radioGrp.checkedRadioButtonId==-1){
                Toast.makeText(requireContext(), "Please select Gender", Toast.LENGTH_SHORT).show()
            }else if (etFullAddress.text.isEmpty()){
                Toast.makeText(requireContext(), "Please enter full address", Toast.LENGTH_SHORT).show()
            }else if (etGovtId.text.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter Government Id", Toast.LENGTH_SHORT)
                    .show()
            }else if (etNationality.text.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter Nationality", Toast.LENGTH_SHORT)
                    .show()
            }
            else{
                currStep++

                when(currStep){

                    1 -> {
                        step1View.visibility = View.VISIBLE
                        step2View.visibility = View.GONE
                        step3View.visibility = View.GONE
                        btnReset.text = "Reset"
                        steps.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.bulletins))
                    }
                    2 -> {
                        step1View.visibility = View.GONE
                        step2View.visibility = View.VISIBLE
                        step3View.visibility = View.GONE
                        btnReset.text = "Previous"
                        steps.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.bulletins_2))
                    }
                    3 -> {
                        step1View.visibility = View.GONE
                        step2View.visibility = View.GONE
                        step3View.visibility = View.VISIBLE
                        btnReset.text = "Previous"
                        steps.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.bulletins_3))
                        btnNext.text = "Save"
                    }

                }
            }

            btnReset.setOnClickListener{
                if (currStep==1){
                    etFullName.text.clear()
                    etFullName.text.clear()
                    radioGrp.clearCheck()
                    etFullAddress.text.clear()
                    etEmplID.text.clear()
                    etNationality.text.clear()
                }
                else{
                    currStep--

                    when(currStep){
                        1 -> {
                            step1View.visibility = View.VISIBLE
                            step2View.visibility = View.GONE
                            step3View.visibility = View.GONE
                            btnReset.text = "Reset"
                            steps.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.bulletins))
                        }
                        2 -> {
                            step1View.visibility = View.GONE
                            step2View.visibility = View.VISIBLE
                            step3View.visibility = View.GONE
                            btnReset.text = "Previous"
                            steps.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.bulletins_2))
                        }
                        3 -> {
                            step1View.visibility = View.GONE
                            step2View.visibility = View.GONE
                            step3View.visibility = View.VISIBLE
                            btnReset.text = "Previous"
                            steps.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.bulletins_3))
                            btnNext.text = "Save"
                        }
                    }
                }
            }

        }

    }


    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, year, monthOfYear, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)
                val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                binding.etDOB.setText(dateFormat.format(selectedDate.time))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
        datePickerDialog.show()
    }


}