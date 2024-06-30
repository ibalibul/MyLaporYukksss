package com.example.mylaporyukksss

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.mylaporyukksss.databinding.FragmentDetailIuranBinding


class DetailIuranFragment : Fragment() {

    lateinit var binding : FragmentDetailIuranBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailIuranBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarDetailIuran.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_detailIuranFragment_to_informasiIuranFragment)
        }
    }


}