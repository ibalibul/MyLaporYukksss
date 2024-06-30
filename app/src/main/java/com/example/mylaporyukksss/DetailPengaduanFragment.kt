package com.example.mylaporyukksss

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.model.ResponseDataFilmItem
import com.example.mylaporyukksss.databinding.FragmentDetailPengaduanBinding


class DetailPengaduanFragment : Fragment() {

    lateinit var binding : FragmentDetailPengaduanBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailPengaduanBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var dataBerita = arguments?.getSerializable("dataBerita") as ResponseDataFilmItem
        binding.txtMonomentNasionalDetail.text = dataBerita.name
        binding.lokasiBerita.text = dataBerita.director
        binding.txtDescripsiBerita.text = dataBerita.desription
        Glide.with(this).load(dataBerita.images).into(binding.imgDetailPengaduan)

        binding.btnBackDetailPengaduan.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_detailPengaduanFragment_to_homeFragment)
        }
    }


}