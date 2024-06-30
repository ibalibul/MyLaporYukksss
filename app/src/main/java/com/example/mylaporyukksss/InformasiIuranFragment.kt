package com.example.mylaporyukksss

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.mylaporyukksss.databinding.FragmentInformasiIuranBinding


class InformasiIuranFragment : Fragment() {

    lateinit var binding : FragmentInformasiIuranBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInformasiIuranBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarInformasiIuran.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_informasiIuranFragment_to_homeFragment)
        }
        binding.btnRincianIuran.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_informasiIuranFragment_to_detailIuranFragment)
        }
    }
}