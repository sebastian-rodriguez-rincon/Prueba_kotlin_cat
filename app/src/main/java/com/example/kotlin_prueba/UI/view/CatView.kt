package com.example.kotlin_prueba.UI.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_prueba.DataFuncionality.CatlModel
import com.example.kotlin_prueba.databinding.ActivityMainBinding
import com.example.kotlin_prueba.UI.viewmodel.CatViewModel

class CatView : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : CatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CatViewModel::class.java)
        viewModel.getCatList()
        println("Holaaaaaa")

    }

    private fun initCat(){

    }
}