package com.example.mylaporyukksss

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.mylaporyukksss.databinding.FragmentPengaduanMasyarakatBinding
import com.example.viewmodel.ViewModelBerita


class PengaduanMasyarakatFragment : Fragment() {

    lateinit var binding : FragmentPengaduanMasyarakatBinding
    val IMAGEPENGADUAN_CODE = 100

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPengaduanMasyarakatBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.toolbarBackPengaduanMasyarakat.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_pengaduanMasyarakatFragment_to_homeFragment)
        }

        binding.imgPengaduanMasyarakat.setOnClickListener{
            cameraPengaduan()
        }
//
//
//        binding.btnKirimPengaduan.setOnClickListener{
//            var namePengaduan = binding.JudulPengaduan.text.toString()
//            var directorPengaduan = binding.lokasiPengaduan.text.toString()
//            var deskripsi = binding.DeskripsiPengaduan.text.toString()
//            var imgaesPengaduan = binding.imgPengaduanMasyarakat.setImageResource()
//            addBerita(namePengaduan,directorPengaduan.toInt(),deskripsi,imgaesPengaduan)
//
//        }
    }

//    fun addBerita(name : String, imgaes : Int, director : String,  desription : String) {
//        var viewModel = ViewModelProvider(this).get(ViewModelBerita::class.java)
//        viewModel.callPostApiBerita(name,imgaes,director,desription)
//        viewModel.postLiveDataBerita().observe(viewLifecycleOwner, Observer {
//             if (it != null)
//                 Toast.makeText(context,"add Data Success",Toast.LENGTH_SHORT).show()
//        })
//    }



    //        Mengambil langsung dari kamera
    private fun cameraPengaduan(){
        val cameraIntentPengaduan = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            cameraResult.launch(cameraIntentPengaduan)
    }

    private val cameraResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result -> if (result.resultCode == Activity.RESULT_OK){
            hendleCameraImagePengaduan(result.data!!)
        }
    }

    private fun hendleCameraImagePengaduan (intent: Intent){
        val bitmap = intent.extras?.get("data") as Bitmap
        binding.imgPengaduanMasyarakat.setImageBitmap(bitmap)
    }
}
