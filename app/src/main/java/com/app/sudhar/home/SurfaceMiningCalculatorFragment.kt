package com.app.sudhar.home

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.app.sudhar.R
import com.app.sudhar.databinding.FragmentSurfaceMiningCalculatorBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter

class SurfaceMiningCalculatorFragment : Fragment() {
    private lateinit var binding:FragmentSurfaceMiningCalculatorBinding
    private var step = 1
    private var step1Emission = 0.00
    private var step2Emission = 0.00
    private var step3Emission = 0.00
    private var step4Emission = 0.00
    private var step5Emission = 0.00
    private var step1ElectricityEmission = 0.00
    private var step2ElectricityEmission = 0.00
    private var step3ElectricityEmission = 0.00
    private var step4ElectricityEmission = 0.00
    private var step5ElectricityEmission = 0.00
    private var step1DieselEmission = 0.00
    private var step2DieselEmission = 0.00
    private var step3DieselEmission = 0.00
    private var step4DieselEmission = 0.00
    private var step5DieselEmission = 0.00
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
                    if (
                        etMachine1.text.toString().isNotEmpty() &&
                        etMachine2.text.toString().isNotEmpty()
                    )
                    {
                        step1DieselEmission = etMachine1.text.toString().toDouble()+etMachine2.text.toString().toDouble()
                    }
                    else if(etMachine1.text.toString().isNotEmpty()){
                        step1DieselEmission = etMachine1.text.toString().toDouble()
                    }
                    else if(etMachine2.text.toString().isNotEmpty()){
                        step1DieselEmission = etMachine2.text.toString().toDouble()
                    }
                    step1DieselEmission *= 2.68

                    if (
                        etMachine3.text.toString().isNotEmpty() &&
                        etMachine4.text.toString().isNotEmpty()
                    )
                    {
                        step1ElectricityEmission = etMachine3.text.toString().toDouble()+etMachine4.text.toString().toDouble()
                    }
                    else if(etMachine3.text.toString().isNotEmpty()){
                        step1ElectricityEmission = etMachine3.text.toString().toDouble()
                    }
                    else if(etMachine4.text.toString().isNotEmpty()){
                        step1ElectricityEmission = etMachine4.text.toString().toDouble()
                    }
                    step1ElectricityEmission *= 0.4
                    step1Emission = step1ElectricityEmission+step1DieselEmission
                    etMachine1.text.clear()
                    etMachine2.text.clear()
                    etMachine3.text.clear()
                    etMachine4.text.clear()
                    tvStepNum.text = "Step 2->Extraction"
                    tvMachineName1.text = "Front-End Loader"
                    tvMachineName2.text = "Truck (Haul Truck)"
                    tvMachineName3.text = "Continuous Miner"
                    tvMachineName4.text = "Electric Rope Shovel"
                }
                2->{
                    if (
                        etMachine1.text.toString().isNotEmpty() &&
                        etMachine2.text.toString().isNotEmpty()
                    )
                    {
                        step2DieselEmission = etMachine1.text.toString().toDouble()+etMachine2.text.toString().toDouble()
                    }
                    else if(etMachine1.text.toString().isNotEmpty()){
                        step2DieselEmission = etMachine1.text.toString().toDouble()
                    }
                    else if(etMachine2.text.toString().isNotEmpty()){
                        step2DieselEmission = etMachine2.text.toString().toDouble()
                    }
                    step2DieselEmission *= 2.68

                    if (
                        etMachine3.text.toString().isNotEmpty() &&
                        etMachine4.text.toString().isNotEmpty()
                    )
                    {
                        step2ElectricityEmission = etMachine3.text.toString().toDouble()+etMachine4.text.toString().toDouble()
                    }
                    else if(etMachine3.text.toString().isNotEmpty()){
                        step2ElectricityEmission = etMachine3.text.toString().toDouble()
                    }
                    else if(etMachine4.text.toString().isNotEmpty()){
                        step2ElectricityEmission = etMachine4.text.toString().toDouble()
                    }
                    step2ElectricityEmission *= 0.4
                    step2Emission = step2ElectricityEmission+step2DieselEmission
                    etMachine1.text.clear()
                    etMachine2.text.clear()
                    etMachine3.text.clear()
                    etMachine4.text.clear()
                    tvStepNum.text = "Step 3->Transportation"
                    tvMachineName1.text = "Load-Haul-Dump(LHD)"
                    tvMachineName2.text = "Truck (Haul Truck)"
                    tvMachineName3.text = "Shuttle Car"
                    tvMachineName4.text = "Conveyor System"
                }
                3->{
                    if (
                        etMachine1.text.toString().isNotEmpty() &&
                        etMachine2.text.toString().isNotEmpty()
                    )
                    {
                        step3DieselEmission = etMachine1.text.toString().toDouble()+etMachine2.text.toString().toDouble()
                    }
                    else if(etMachine1.text.toString().isNotEmpty()){
                        step3DieselEmission = etMachine1.text.toString().toDouble()
                    }
                    else if(etMachine2.text.toString().isNotEmpty()){
                        step3DieselEmission = etMachine2.text.toString().toDouble()
                    }
                    step3DieselEmission *= 2.68

                    if (
                        etMachine3.text.toString().isNotEmpty() &&
                        etMachine4.text.toString().isNotEmpty()
                    )
                    {
                        step3ElectricityEmission = etMachine3.text.toString().toDouble()+etMachine4.text.toString().toDouble()
                    }
                    else if(etMachine3.text.toString().isNotEmpty()){
                        step3ElectricityEmission = etMachine3.text.toString().toDouble()
                    }
                    else if(etMachine4.text.toString().isNotEmpty()){
                        step3ElectricityEmission = etMachine4.text.toString().toDouble()
                    }
                    step3ElectricityEmission *= 0.4
                    step3Emission = step3ElectricityEmission+step3DieselEmission
                    etMachine1.text.clear()
                    etMachine2.text.clear()
                    etMachine3.text.clear()
                    etMachine4.text.clear()
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
                    if (
                        etMachine1.text.toString().isNotEmpty() &&
                        etMachine2.text.toString().isNotEmpty()
                    )
                    {
                        step4DieselEmission = etMachine1.text.toString().toDouble()+etMachine2.text.toString().toDouble()
                    }
                    else if(etMachine1.text.toString().isNotEmpty()){
                        step4DieselEmission = etMachine1.text.toString().toDouble()
                    }
                    else if(etMachine2.text.toString().isNotEmpty()){
                        step4DieselEmission = etMachine2.text.toString().toDouble()
                    }
                    step4DieselEmission *= 2.68

                    if (
                        etMachine3.text.toString().isNotEmpty() &&
                        etMachine4.text.toString().isNotEmpty()
                    )
                    {
                        step4ElectricityEmission = etMachine3.text.toString().toDouble()+etMachine4.text.toString().toDouble()
                    }
                    else if(etMachine3.text.toString().isNotEmpty()){
                        step4ElectricityEmission = etMachine3.text.toString().toDouble()
                    }
                    else if(etMachine4.text.toString().isNotEmpty()){
                        step4ElectricityEmission = etMachine4.text.toString().toDouble()
                    }
                    step4ElectricityEmission *= 0.4
                    step4Emission = step4ElectricityEmission+step4DieselEmission
                    etMachine1.text.clear()
                    etMachine2.text.clear()
                    etMachine3.text.clear()
                    etMachine4.text.clear()
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
                    if (
                        etMachine1.text.toString().isNotEmpty() &&
                        etMachine2.text.toString().isNotEmpty()
                    )
                    {
                        step5DieselEmission = etMachine1.text.toString().toDouble()+etMachine2.text.toString().toDouble()
                    }
                    else if(etMachine1.text.toString().isNotEmpty()){
                        step5DieselEmission = etMachine1.text.toString().toDouble()
                    }
                    else if(etMachine2.text.toString().isNotEmpty()){
                        step5DieselEmission = etMachine2.text.toString().toDouble()
                    }
                    step5DieselEmission *= 2.68

                    if (
                        etMachine3.text.toString().isNotEmpty() &&
                        etMachine4.text.toString().isNotEmpty()
                    )
                    {
                        step5ElectricityEmission = etMachine3.text.toString().toDouble()+etMachine4.text.toString().toDouble()
                    }
                    else if(etMachine3.text.toString().isNotEmpty()){
                        step5ElectricityEmission = etMachine3.text.toString().toDouble()
                    }
                    else if(etMachine4.text.toString().isNotEmpty()){
                        step5ElectricityEmission = etMachine4.text.toString().toDouble()
                    }
                    step5ElectricityEmission *= 0.4
                    step5Emission = step5ElectricityEmission+step5DieselEmission
                    etMachine1.text.clear()
                    etMachine2.text.clear()
                    etMachine3.text.clear()
                    etMachine4.text.clear()
                    grpData.visibility = View.GONE
                    pieChart.visibility = View.VISIBLE
                    tvTotalEmission.visibility = View.VISIBLE
                    tvTotalEmission.text = "Total Emission-- ${step1Emission+step2Emission+step3Emission+step4Emission+step5Emission} kg CO2"
                    initPieChart()
                    showPieChart()
                }
            }
            step++
        }
    }
    private fun showPieChart()=binding.apply{
        val pieEntries = ArrayList<PieEntry>()
        val label = "Process"

        //initializing data
        val typeAmountMap: MutableMap<String, Double> = HashMap()
        typeAmountMap["Exploration and Drilling"] = step1Emission
        typeAmountMap["Extraction"] = step2Emission
        typeAmountMap["Transportation"] = step3Emission
        typeAmountMap["Processing and handling"] = step4Emission
        typeAmountMap["Site Reclamation"] = step5Emission

        //initializing colors for the entries
        val colors = ArrayList<Int>()
        colors.add(Color.parseColor("#304567"))
        colors.add(Color.parseColor("#309967"))
        colors.add(Color.parseColor("#476567"))
        colors.add(Color.parseColor("#890567"))
        colors.add(Color.parseColor("#a35567"))
        colors.add(Color.parseColor("#ff5f67"))
        colors.add(Color.parseColor("#3ca567"))

        //input data and fit data into pie chart entry
        for (type in typeAmountMap.keys) {
            pieEntries.add(PieEntry(typeAmountMap[type]!!.toFloat(), type))
        }

        //collecting the entries with label name
        val pieDataSet = PieDataSet(pieEntries, label)
        //setting text size of the value
        pieDataSet.valueTextSize = 12f
        //providing color list for coloring different entries
        pieDataSet.colors = colors
        //grouping the data set from entry to chart
        val pieData = PieData(pieDataSet)
        pieData.setValueFormatter(PercentFormatter())
        //showing the value of the entries, default true if not set
        pieData.setDrawValues(true)

        pieChart.setData(pieData)
        pieChart.setEntryLabelColor(Color.WHITE)
        pieChart.invalidate()
    }
    private fun initPieChart()=binding.apply{
        //using percentage as values instead of amount
        pieChart.setUsePercentValues(true)

        //remove the description label on the lower left corner, default true if not set
        pieChart.description.isEnabled = true
        pieChart.description.text = "Process"
        pieChart.description.textColor = ContextCompat.getColor(requireContext(),R.color.white)

        //enabling the user to rotate the chart, default true
        pieChart.isRotationEnabled = true
        //adding friction when rotating the pie chart
        pieChart.setDragDecelerationFrictionCoef(0.9f)
        //setting the first entry start from right hand side, default starting from top
        pieChart.setRotationAngle(0F)
        pieChart.setDrawCenterText(true)
        pieChart.setDrawEntryLabels(true)
        pieChart.setDrawMarkers(false)

        pieChart.legend.isEnabled = true
        pieChart.legend.isWordWrapEnabled = true
        pieChart.legend.textColor= ContextCompat.getColor(requireContext(),R.color.white)

        //highlight the entry when it is tapped, default true if not set
        pieChart.isHighlightPerTapEnabled = true
        //adding animation so the entries pop up from 0 degree
        pieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad)
        //setting the color of the hole in the middle, default white
        pieChart.setHoleColor(Color.parseColor("#000000"))
    }
}
