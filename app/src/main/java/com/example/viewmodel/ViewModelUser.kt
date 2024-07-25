package com.example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.model.DataUser
import com.example.model.ResponseDataUserrItem
import com.example.network.RetrofitUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelUser : ViewModel() {

    lateinit var liveDataUser: MutableLiveData<List<ResponseDataUserrItem>?>
    lateinit var postDatauser: MutableLiveData<ResponseDataUserrItem?>

    init {
        liveDataUser = MutableLiveData()
        postDatauser = MutableLiveData()
    }

    fun getLivedataUser() : MutableLiveData<List<ResponseDataUserrItem>?> {
        return liveDataUser
    }

    fun postLivedataUser() : MutableLiveData<ResponseDataUserrItem?> {
        return postDatauser
    }

    fun callApiUser(){
        RetrofitUser.instance.getAllUser()
            .enqueue(object: Callback<List<ResponseDataUserrItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataUserrItem>>,
                    response: Response<List<ResponseDataUserrItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataUser.postValue(response.body())
                    }else
                        liveDataUser.postValue(null)
                }

                override fun onFailure(call: Call<List<ResponseDataUserrItem>>, t: Throwable) {
                    liveDataUser.postValue(null)
                }


            })
    }

    fun postApiUser(name: String, email: String, password: String,notlp: Long) {
        RetrofitUser.instance.addPostUser(DataUser(name, email, password, notlp))
            .enqueue(object : Callback<ResponseDataUserrItem> {
                override fun onResponse(
                    call: Call<ResponseDataUserrItem>,
                    response: Response<ResponseDataUserrItem>
                ) {
                    if (response.isSuccessful){
                        postDatauser.postValue(response.body())
                    }else
                        postDatauser.postValue(null)
                }

                override fun onFailure(call: Call<ResponseDataUserrItem>, t: Throwable) {
                    postDatauser.postValue(null)
                }

            })
    }
}