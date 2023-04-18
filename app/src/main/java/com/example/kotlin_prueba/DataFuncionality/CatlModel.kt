package com.example.kotlin_prueba.DataFuncionality

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CatlModel(
   @SerializedName("name")val name:String,
   @Expose @SerializedName("origin")val origin:String,
   @Expose @SerializedName("intelligence")val intelligence:String,
   @Expose @SerializedName("reference_image_id")val reference_image_id:String)


