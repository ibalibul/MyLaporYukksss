package com.example.mylaporyukksss

import android.app.DatePickerDialog
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adapter.BeritaAdapter
import com.example.mylaporyukksss.databinding.FragmentHomeBinding
import com.example.viewmodel.ViewModelBerita
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class HomeFragment : Fragment() {

    lateinit var adapterBerita : BeritaAdapter
    lateinit var binding : FragmentHomeBinding
    lateinit var viewModelUser : ViewModelBerita
    lateinit var crdCalender : CardView
    lateinit var tvdate : TextView
    private  var calender = Calendar.getInstance()
    lateinit var sp : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModelUser = ViewModelProvider(this).get(viewModelUser::class.java)


        binding.accout.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_profileFragment)
        }
        binding.crdIuranBulanan.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_homeFragment_to_informasiIuranFragment)

        }
        binding.crdPengaduanMasyarak.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_homeFragment_to_pengaduanMasyarakatFragment)
        }
        binding.cardProfileDesa.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_homeFragment_to_statistikDesaFragment)
        }


        binding.crdKalender.setOnClickListener {
            showPickerDialog()
        }

//        sp = requireActivity().getSharedPreferences("userdata",Context.MODE_PRIVATE)
//
//        var getName = sp.getString("name", "")
//        var getemail = sp.getString("email", "")
//        var getpassword = sp.getString("password", "")
//        binding.txtUser.setText(getName)

        showDataFilm()




    }


//  Menampilka Berita

    fun showDataFilm(){
        val  viewModel = ViewModelProvider(this).get(ViewModelBerita::class.java)
        viewModel.callApiBerita()
        viewModel.getLiveDataBerita().observe(viewLifecycleOwner, Observer {
            if (it != null)
                binding.rvBerita.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
                binding.rvBerita.adapter = BeritaAdapter(it)
        })

    }

//    Menampilkan Kalender

    private fun showPickerDialog() {
        val datePickerDialog = DatePickerDialog(requireContext(),{DatePicker,year: Int,monthOfYear: Int,dayOfMonth: Int ->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(year,monthOfYear,dayOfMonth)
            val dateFormat = SimpleDateFormat("dd/MM/yyyy",Locale.getDefault())
            val formattedDate = dateFormat.format(selectedDate.time)
            tvdate.text = "Selected Date:" + formattedDate

        },
            calender.get(Calendar.YEAR),
            calender.get(Calendar.MONTH),
            calender.get(Calendar.DAY_OF_MONTH)

        )
        datePickerDialog.show()
    }

}