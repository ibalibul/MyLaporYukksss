package com.example.mylaporyukksss

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adapter.BungurAdapter
import com.example.adapter.ListBungur
import com.example.mylaporyukksss.databinding.FragmentStatistikDesaBinding


class StatistikDesaFragment : Fragment() {

    lateinit var binding : FragmentStatistikDesaBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStatistikDesaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val listBungur = arrayListOf(
            ListBungur("Situ Bungur","Bungurr Kereenn","ASDAD",R.drawable.img_4),
            ListBungur("Situ Bungur","Bungurr Kereenn","ASASASDA",R.drawable.img_5),
            ListBungur("Situ Bungur","Bungurr Kereenn","aasdasfdfsf",R.drawable.img_6),
            ListBungur("Situ Bungur","Bungurr Kereenn","asdafdsfsfgf",R.drawable.img_7)
        )
        binding.rvBungurr.adapter = BungurAdapter(listBungur)
        binding.rvBungurr.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        var adapterBungurrr = BungurAdapter(listBungur)
//        adapterBungurrr.onClick = {
//        var pindah = Intent(context,DetailPotensiFragment::class.java)
//            pindah.putExtra("detail",listBungur)
//            startActivity(pindah)
//        }




        binding.toolbarStatistikDesa.setOnClickListener{
            Navigation.findNavController(view)
                .navigate(R.id.action_statistikDesaFragment_to_homeFragment)
        }

        binding.apply {
            StatistikDesaa.animation.duration = animationDuration
            StatistikDesaa.animate(datSet)
        }

    }

    companion object {
        private val datSet = listOf(
            "JAN" to 4F,
            "FEB" to 7F,
            "MAR" to 8F,
            "APR" to 9F,
            "MEI" to 1F,
            "JUN" to 10F,
        )
        private const val animationDuration = 1000L
    }





}

