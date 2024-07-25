package com.example.mylaporyukksss

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.model.ResponseDataUserrItem
import com.example.mylaporyukksss.databinding.FragmentLoginBinding
import com.example.network.RetrofitUser
import com.example.viewmodel.ViewModelUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : Fragment() {

    lateinit var binding : FragmentLoginBinding
    lateinit var viewModelUser : ViewModelUser
    lateinit var sharedpref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedpref = requireActivity().getSharedPreferences("userdata",Context.MODE_PRIVATE)

        binding.btnlogin.setOnClickListener{
//            var inputUsername = binding.ednameLogin.text.toString()
//            var emailUser = binding.adminEmail.text.toString()
//            var inputPassword = binding.adminPassword.text.toString()
//
//            var userName = sharedpref.getString("name", "")
//            var email = sharedpref.getString("email", "")
//            var password = sharedpref.getString("passwor","")
//            loginUser(inputUsername,emailUser,inputPassword)

//            if (emailUser != null && inputPassword != null){
//                viewModelUser = ViewModelProvider(this).get(ViewModelUser::class.java)

//            }else if (emailUser == null && inputPassword == null) Toast.makeText(
//                context,
//                "Empty Username or Password!",
//                Toast.LENGTH_SHORT
//            ).show()
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)
        }
        binding.textSignIn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment)
        }

    }


    fun loginUser(name: String,passwords: String, email: String){
        RetrofitUser.instance.getAllUser()
            .enqueue(object : Callback<List<ResponseDataUserrItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataUserrItem>>,
                    response: Response<List<ResponseDataUserrItem>>
                ) {
                    var data = false
                    if (response.isSuccessful){
                        if (response.body()!=null){
                            val respon = response.body()
                            for(i in 0 until respon!!.size){
                                if (respon[i].name == name && respon[i].password == passwords && respon[i].email == email){
                                    data = true

                                    var addUser = sharedpref.edit()
                                    addUser.putString("name", name)
                                    addUser.putString("email", email)
                                    addUser.putString("password", passwords)
                                    addUser.apply()
                                    Toast.makeText(context,"Login",Toast.LENGTH_SHORT)
                                        .show()
                                    Navigation.findNavController(view!!)
                                        .navigate(R.id.action_loginFragment_to_homeFragment)
                                }
                            }
                            if (data == false) Toast.makeText(
                                context,"Wrong Username or password",Toast.LENGTH_SHORT
                            ).show()
                        }
                        else Toast.makeText(context, "Empty Response!", Toast.LENGTH_SHORT).show()
                    }
                    else Toast.makeText(context, "Failed Laod Data", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<List<ResponseDataUserrItem>>, t: Throwable) {
                    Toast.makeText(context, "Failed Laod Data", Toast.LENGTH_SHORT).show()
                }


            })
    }
}