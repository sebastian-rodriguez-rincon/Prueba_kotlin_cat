package com.example.kotlin_prueba.UI.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_prueba.UI.adapter.CatAdapter
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

        binding.catListRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.catListRecyclerView.adapter = CatAdapter()
        viewModel.getCatList()
        viewModel.catList.observe(this, Observer { list ->(binding.catListRecyclerView.adapter as CatAdapter).setData(list) })
        //viewModel.catList.observe()
        println("Holaaaaaa")

    }

}