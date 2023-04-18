package com.example.kotlin_prueba.network

import com.example.kotlin_prueba.DataFuncionality.CatlModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface CatApi {
    @Headers("x-api-key: bda53789-d59e-46cd-9bc4-2936630fde39")
    @GET("breeds")
    fun getAllCat(): Call<ArrayList<CatlModel>>
}