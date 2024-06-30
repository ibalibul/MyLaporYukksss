package com.example.mylaporyukksss

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.adapter.BungurAdapter
import com.example.adapter.ListBungur
import com.example.mylaporyukksss.databinding.FragmentDetailPotensiBinding


class DetailPotensiFragment : Fragment() {

    lateinit var binding : FragmentDetailPotensiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailPotensiBinding.inflate(inflater,container,false)
        return binding.root




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var dataBungur =arguments?.getSerializable("databungur") as ListBungur
        binding.txtNamePDBungur.text = dataBungur.name
        binding.txtDescripsiPDBungur.text = dataBungur.Description
        Glide.with(this).load(dataBungur.img).into(binding.imgDPDesaa)


        binding.btnBackDPDesa.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_detailPotensiFragment_to_statistikDesaFragment)
        }
    }

//    fun getdata() {
//        var getDetailData = intArrayOf("detail")
//    }




}