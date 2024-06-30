package com.example.mylaporyukksss

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.mylaporyukksss.databinding.FragmentDetailAccountBinding


class DetailAccountFragment : Fragment() {
    
    lateinit var binding : FragmentDetailAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailAccountBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarDetailAccountprofile.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_detailAccountFragment_to_profileFragment)
        }
    }
}