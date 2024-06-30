package com.example.mylaporyukksss

import android.app.Activity
import android.app.AlertDialog
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.navigation.Navigation
import com.example.mylaporyukksss.databinding.FragmentProfileBinding
import kotlinx.coroutines.NonCancellable.cancel
import okhttp3.internal.parseCookie


class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding
    val IMAGE_CODE = 100


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarBack.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_profileFragment_to_homeFragment)
        }

        binding.btnHelp.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_profileFragment_to_helpFragment)
        }

        binding.btnAccountname.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_profileFragment_to_detailAccountFragment)
        }

        binding.imgProfile.setOnClickListener {
            pickImageFromGallery()
        }
    }




    private fun chooseImageDialoge() {
        AlertDialog.Builder(context)
            .setMessage("Pilih Gambar")
            .setPositiveButton("Gallery"){_,_->pickImageFromGallery()}
            .setNegativeButton("Camera"){_,_->openCamera()}
    }



    ////    Mengambil Langsung dari Galeri
    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_CODE && resultCode == AppCompatActivity.RESULT_OK) {
            binding.imgProfile.setImageURI(data?.data)
        }
    }

//    Mengampil langsung dari kamera
    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraResult.launch(cameraIntent)
    }

    private val cameraResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result -> if (result.resultCode == Activity.RESULT_OK) {
        handleCameraImage(result.data!!)

        }
    }

    private fun handleCameraImage(intent : Intent){
        val bitmap = intent.extras?.get("data") as Bitmap
        binding.imgProfile.setImageBitmap(bitmap)
    }


}
