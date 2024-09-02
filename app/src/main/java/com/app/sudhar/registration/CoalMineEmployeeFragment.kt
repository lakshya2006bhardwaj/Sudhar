package com.app.sudhar.registration

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.app.sudhar.R
import com.app.sudhar.databinding.FragmentCoalMineEmployeeBinding
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class CoalMineEmployeeFragment : Fragment() {
    private lateinit var binding: FragmentCoalMineEmployeeBinding
    private var currStep = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCoalMineEmployeeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initSetViews()
        initClickListeners()
    }

    private fun initSetViews() = binding.apply {
        step1View.visibility = View.VISIBLE
        step2View.visibility = View.GONE
        step3View.visibility = View.GONE
    }

    private fun initClickListeners() = binding.apply {
        etDOB.setOnClickListener {
            showDatePickerDialog()
        }
        btnNext.setOnClickListener {
            if (etFullName.text.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter Full Name", Toast.LENGTH_SHORT)
                    .show()
            } else if (etDOB.text.isEmpty()) {
                Toast.makeText(requireContext(), "Please select DOB", Toast.LENGTH_SHORT).show()
            } else if (radioGrp.checkedRadioButtonId == -1) {
                Toast.makeText(requireContext(), "Please select gender", Toast.LENGTH_SHORT).show()
            } else if (etFullAddress.text.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter full address", Toast.LENGTH_SHORT)
                    .show()
            } else {
                currStep++
                when (currStep) {
                    1 -> {
                        step1View.visibility = View.VISIBLE
                        step2View.visibility = View.GONE
                        step3View.visibility = View.GONE
                        btnReset.text = "Reset"
                        steps.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.bulletins
                            )
                        )
                    }

                    2 -> {
                        step1View.visibility = View.GONE
                        step2View.visibility = View.VISIBLE
                        step3View.visibility = View.GONE
                        btnReset.text = "Previous"
                        steps.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.bulletins_2
                            )
                        )
                    }

                    3 -> {
                        step1View.visibility = View.GONE
                        step2View.visibility = View.GONE
                        step3View.visibility = View.VISIBLE
                        btnReset.text = "Previous"
                        steps.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.bulletins_3
                            )
                        )
                        btnNext.text = "Save"
                    }

                    4 -> {
                        showCustomDialog()
                    }
                }
            }

            btnReset.setOnClickListener {
                if (currStep == 1) {
                    etFullName.text.clear()
                    etDOB.text.clear()
                    radioGrp.clearCheck()
                    etFullAddress.text.clear()
                } else {
                    currStep--
                    when (currStep) {
                        1 -> {
                            step1View.visibility = View.VISIBLE
                            step2View.visibility = View.GONE
                            step3View.visibility = View.GONE
                            btnReset.text = "Reset"
                            steps.setImageDrawable(
                                ContextCompat.getDrawable(
                                    requireContext(),
                                    R.drawable.bulletins
                                )
                            )
                        }

                        2 -> {
                            step1View.visibility = View.GONE
                            step2View.visibility = View.VISIBLE
                            step3View.visibility = View.GONE
                            btnReset.text = "Previous"
                            steps.setImageDrawable(
                                ContextCompat.getDrawable(
                                    requireContext(),
                                    R.drawable.bulletins_2
                                )
                            )
                        }

                        3 -> {
                            step1View.visibility = View.GONE
                            step2View.visibility = View.GONE
                            step3View.visibility = View.VISIBLE
                            btnReset.text = "Previous"
                            steps.setImageDrawable(
                                ContextCompat.getDrawable(
                                    requireContext(),
                                    R.drawable.bulletins_3
                                )
                            )
                            btnNext.text = "Save"
                        }

                        4 -> {
                            showCustomDialog()
                        }
                    }
                }
            }
        }
    }

    private fun showCustomDialog() {
        val dialogView = layoutInflater.inflate(R.layout.confirm_password_registration_layout, null)

        val dialogBuilder = AlertDialog.Builder(requireContext())
            .setView(dialogView)

        val submit = dialogView.findViewById<Button>(R.id.btnSubmit)
        val alertDialog = dialogBuilder.create()

        submit.setOnClickListener {
            val userId = dialogView.findViewById<EditText>(R.id.etUserID).text.toString()
            val password =
                dialogView.findViewById<TextInputEditText>(R.id.etPassword).text.toString()
            val confirmPassword = dialogView.findViewById<EditText>(R.id.etConfirm).text.toString()

            if (password == confirmPassword) {
                // Proceed with the logic
                Toast.makeText(requireContext(), "Data Submitted", Toast.LENGTH_SHORT).show()
                alertDialog.dismiss()
                securityQuestionDialogBox()

            } else {
                Toast.makeText(requireContext(), "Passwords do not match", Toast.LENGTH_SHORT)
                    .show()
            }
            // Dismiss the dialog after submission
        }

        alertDialog.show()
    }

    fun securityQuestionDialogBox() {
        val dialogView =
            layoutInflater.inflate(R.layout.employee_confirm_password_registration, null)

        val dialogBuilder = AlertDialog.Builder(requireContext())
            .setView(dialogView)

        val submit = dialogView.findViewById<Button>(R.id.btnsecure)
        val alertDialog = dialogBuilder.create()
        val securitySpinner = dialogView.findViewById<Spinner>(R.id.securityspinner)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.security,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            securitySpinner.adapter = adapter
        }
        securitySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent.getItemAtPosition(position).toString()

                // You can add additional logic here based on the selected item
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle the case where no item is selected
            }
        }

        submit.setOnClickListener {

            val password =
                dialogView.findViewById<TextInputEditText>(R.id.etPassword).text.toString()
            val confirmPassword =
                dialogView.findViewById<EditText>(R.id.etConfirmPassword).text.toString()

            if (password == confirmPassword) {
                // Proceed with the logic
                Toast.makeText(requireContext(), "Data Submitted", Toast.LENGTH_SHORT).show()
                alertDialog.dismiss()

            } else {
                Toast.makeText(requireContext(), "Passwords do not match", Toast.LENGTH_SHORT)
                    .show()
            }
            // Dismiss the dialog after submission
        }

        alertDialog.show()
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