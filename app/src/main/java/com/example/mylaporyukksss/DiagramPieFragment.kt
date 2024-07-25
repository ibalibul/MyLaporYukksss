package com.example.mylaporyukksss

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mylaporyukksss.databinding.FragmentDiagramPieBinding
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieEntry


class DiagramPieFragment : Fragment() {

    lateinit var binding : FragmentDiagramPieBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDiagramPieBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}