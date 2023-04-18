package com.example.kotlin_prueba.network

import com.example.kotlin_prueba.DataFuncionality.CatlModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface CatApi {
    @GET("breeds")
    fun getAllCat(): Call<ArrayList<CatlModel>>
}