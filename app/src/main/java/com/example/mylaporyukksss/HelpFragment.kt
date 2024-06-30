package com.example.mylaporyukksss

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.mylaporyukksss.databinding.FragmentHelpBinding

class HelpFragment : Fragment() {

    lateinit var  binding : FragmentHelpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHelpBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarHelpProfile.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_helpFragment_to_profileFragment)
        }
    }




}