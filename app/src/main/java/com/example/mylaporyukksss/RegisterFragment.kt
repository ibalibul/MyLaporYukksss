package com.example.mylaporyukksss

import android.content.SharedPreferences
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.mylaporyukksss.databinding.FragmentRegisterBinding
import com.example.viewmodel.ViewModelUser


class RegisterFragment : Fragment() {

    lateinit var binding : FragmentRegisterBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnRegister.setOnClickListener{
            var name = binding.editNama.text.toString()
            var email = binding.editemail.text.toString()
            var password = binding.editpassword.text.toString()
            val notlp = binding.editpassword.text.toString()
//            if (name.equals(password)){
                postDataUser(name,email,password,notlp.toLong())
//
//                Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment)
//            }


        }
    }

    fun postDataUser(name : String,email : String, password :String,notlp: Long) {
        val viewModel = ViewModelProvider(this).get(ViewModelUser::class.java)
        viewModel.postApiUser(name,email,password,notlp)
        viewModel.postLivedataUser().observe(viewLifecycleOwner,{
            if (it != null){
                Toast.makeText(context,"Add Data Successfull", Toast.LENGTH_SHORT).show()
                Log.d("addUser", it.toString())
                Navigation.findNavController(requireView()).navigate(R.id.action_registerFragment_to_loginFragment)
            }
        })

    }


}