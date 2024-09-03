package com.app.sudhar.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.sudhar.R
import com.app.sudhar.databinding.FragmentSurfaceMiningCalculatorBinding

class SurfaceMiningCalculatorFragment : Fragment() {
    private lateinit var binding:FragmentSurfaceMiningCalculatorBinding
    private var step = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding  = FragmentSurfaceMiningCalculatorBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init(){
        initClickListener()
        initSetViews()
    }

    private fun initSetViews() {

    }

    private fun initClickListener()=binding.apply{
        nextBtn.setOnClickListener {
            when(step){
                1->{
                    tvStepNum.text = "Step 2->Extraction"
                    tvMachineName1.text = "Front-End Loader"
                    tvMachineName2.text = "Truck (Haul Truck)"
                    tvMachineName3.text = "Continuous Miner"
                    tvMachineName4.text = "Electric Rope Shovel"
                }
                2->{
                    tvStepNum.text = "Step 3->Transportation"
                    tvMachineName1.text = "Load-Haul-Dump(LHD)"
                    tvMachineName2.text = "Truck (Haul Truck)"
                    tvMachineName3.text = "Shuttle Car"
                    tvMachineName4.text = "Conveyor System"
                }
                3->{
                    tvStepNum.text = "Step 4->Processing and Handling"
                    tvMachineName1.visibility = View.GONE
                    tvMachineName2.visibility = View.GONE
                    tvMachinesDiesel.visibility = View.GONE
                    etMachine1.visibility = View.GONE
                    etMachine2.visibility = View.GONE
                    tvMachineName3.text = "Crusher"
                    tvMachineName4.text = "Screening Plant"
                    tvMachinesElectricity.visibility = View.VISIBLE
                    tvMachineName3.visibility = View.VISIBLE
                    tvMachineName4.visibility = View.VISIBLE
                    etMachine3.visibility = View.VISIBLE
                    etMachine4.visibility = View.VISIBLE
                }
                4->{
                    tvMachineName1.visibility = View.VISIBLE
                    tvMachineName2.visibility = View.VISIBLE
                    tvMachinesDiesel.visibility = View.VISIBLE
                    etMachine1.visibility = View.VISIBLE
                    etMachine2.visibility = View.VISIBLE
                    tvStepNum.text = "Step 5->Site Reclamation"
                    nextBtn.text = "Calculate"
                    tvMachineName1.text = "Bulldozer"
                    tvMachineName2.text = "Excavator"
                    tvMachinesElectricity.visibility = View.GONE
                    tvMachineName3.visibility = View.GONE
                    tvMachineName4.visibility = View.GONE
                    etMachine3.visibility = View.GONE
                    etMachine4.visibility = View.GONE
                }
                5->{

                }
            }
        }
    }
}
