package com.example.kotlin_prueba.UI.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_prueba.DataFuncionality.CatlModel
import com.example.kotlin_prueba.network.CatApi
import com.google.gson.JsonArray
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory


class CatViewModel() : ViewModel() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: CatApi = retrofit.create(CatApi::class.java)

    val catList = MutableLiveData<CatlModel>()

    fun getCatList() {
        val call = service.getAllCat()

        call.enqueue(object : Callback<ArrayList<CatlModel>> {
          override fun onResponse(
                call: Call<ArrayList<CatlModel>>,
                response: Response<ArrayList<CatlModel>>
            ) {
              if (response.isSuccessful) {

          }
          }

            override fun onFailure(call: Call<ArrayList<CatlModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}

