package com.example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.model.DataFilm
import com.example.model.PostResponseFilm
import com.example.model.ResponseDataFilmItem
import com.example.model.ResponseDataPengaduanItem
import com.example.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelBerita : ViewModel() {

    private var liveDataBerita : MutableLiveData<List<ResponseDataPengaduanItem>?>
    lateinit var postBerita : MutableLiveData<PostResponseFilm?>

    init {
        liveDataBerita = MutableLiveData()
        postBerita = MutableLiveData()
    }

    fun getLiveDataBerita() : MutableLiveData<List<ResponseDataPengaduanItem>?>{
        return liveDataBerita
    }

//    fun postLiveDataBerita() : MutableLiveData<PostResponseFilm?> {
//        return  postBerita
//    }

    fun callApiBerita(){
        RetrofitClient.instance.getallPengaduan()
            .enqueue(object : Callback<List<ResponseDataPengaduanItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataPengaduanItem>>,
                    response: Response<List<ResponseDataPengaduanItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataBerita.postValue(response.body())
                    }else
                        liveDataBerita.postValue(null)
                }

                override fun onFailure(call: Call<List<ResponseDataPengaduanItem>>, t: Throwable) {
                    liveDataBerita.postValue(null)
                }

            })
    }
//
//    fun callPostApiBerita(name : String, imgaes : String, director : String,  desription : String){
//        RetrofitClient.instance.addDataFilm(DataFilm(name,imgaes,director,desription))
//            .enqueue(object : Callback<PostResponseFilm>{
//                override fun onResponse(
//                    call: Call<PostResponseFilm>,
//                    response: Response<PostResponseFilm>
//                ) {
//                    if (response.isSuccessful){
//                        postBerita.postValue(response.body())
//                    }else{
//                        postBerita.postValue(null)
//                    }
//                }
//
//                override fun onFailure(call: Call<PostResponseFilm>, t: Throwable) {
//                    postBerita.postValue(null)
//                }
//
//            })
//    }


}