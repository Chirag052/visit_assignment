package com.techhustlers.visitassignment.ui.daily

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.LargeValueFormatter
import com.github.mikephil.charting.utils.MPPointF
import com.techhustlers.visitassignment.R
import com.techhustlers.visitassignment.databinding.FragmentDailyBinding


class DailyFragment : Fragment() {

    lateinit var binding: FragmentDailyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentDailyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }


    private fun setData(){
        val barWidth: Float
        barWidth = 0.4f
        val xvalues = arrayOf<String>("Mon","Tue","Wed","Thu","Fri","Sat","Sun")
        var yValueGroup1 = ArrayList<BarEntry>()

        yValueGroup1.add(0,BarEntry(0.5f, floatArrayOf(50.toFloat(), 40.toFloat())))
        yValueGroup1.add(1,BarEntry(1.5f, floatArrayOf(130.toFloat(), 100.toFloat()),ContextCompat.getDrawable(requireContext(),R.drawable.ic_baseline_check_24)))
        yValueGroup1.add(2,BarEntry(2.5f, floatArrayOf(50.toFloat()),ContextCompat.getDrawable(requireContext(),R.drawable.ic_baseline_check_24)))
        yValueGroup1.add(2,BarEntry(2.5f, floatArrayOf(50.toFloat(),70.toFloat())))
        yValueGroup1.add(3,BarEntry(3.5f, floatArrayOf(70.toFloat(), 80.toFloat())))
        yValueGroup1.add(4,BarEntry(4.5f, floatArrayOf(130.toFloat(), 140.toFloat())))
        yValueGroup1.add(5,BarEntry(5.5f, floatArrayOf(65.toFloat(), 120.toFloat())))
        yValueGroup1.add(6,BarEntry(6.5f, floatArrayOf(20.toFloat(), 50.toFloat())))


        var barDataSet1: BarDataSet
        barDataSet1 = BarDataSet(yValueGroup1, "")
        barDataSet1.setColors(Color.parseColor("#5A68E7"), Color.parseColor("#FF865C"))

        barDataSet1.setDrawIcons(true)
        barDataSet1.setDrawValues(false)
        barDataSet1.stackLabels = xvalues
        barDataSet1.iconsOffset = MPPointF.getInstance(0f, 16f)

        var barData = BarData(barDataSet1)

        binding.chart.description.isEnabled = false
        binding.chart.description.textSize = 0f
        barData.setValueFormatter(LargeValueFormatter())
        binding.chart.setData(barData)
        binding.chart.getBarData().setBarWidth(barWidth)
        binding.chart.getXAxis().setAxisMinimum(0f)
        binding.chart.getXAxis().setAxisMaximum(3f)
        binding.chart.getData().setHighlightEnabled(false)
        binding.chart.invalidate()
        binding.chart.setFitBars(true)
        binding.chart.animateY(1000)
        binding.chart.legend.isEnabled = false
        binding.chart.axisRight.isEnabled = false
        binding.chart.barData.setDrawValues(false)

        val barChartRender =
            CustomBarChartRender(binding.chart, binding.chart.getAnimator(), binding.chart.getViewPortHandler())
        barChartRender.setRadius(16)
        binding.chart.setRenderer(barChartRender)

        val xAxis = binding.chart.getXAxis()
        xAxis.setGranularity(0f)
        xAxis.setGranularityEnabled(true)
        xAxis.setCenterAxisLabels(true)
        xAxis.setDrawGridLines(false)
        xAxis.textSize = 9f

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM)
        val index = IndexAxisValueFormatter(xvalues)
        xAxis.setValueFormatter(index)

        xAxis.setLabelCount(7)
        xAxis.mAxisMaximum = 7f

        xAxis.setCenterAxisLabels(true)
        xAxis.setAvoidFirstLastClipping(false)

        val leftAxis = binding.chart.getAxisLeft()
        leftAxis.setValueFormatter(LargeValueFormatter())
        leftAxis.setDrawGridLines(true)
        leftAxis.gridColor = Color.parseColor("#F0F3F6")
        leftAxis.setSpaceTop(1f)
        leftAxis.setAxisMinimum(0f)

        binding.chart.data = barData

    }

}