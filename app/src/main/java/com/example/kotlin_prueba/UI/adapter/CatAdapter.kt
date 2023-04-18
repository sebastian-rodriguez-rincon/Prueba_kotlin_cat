package com.example.kotlin_prueba.UI.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_prueba.DataFuncionality.CatlModel
import com.example.kotlin_prueba.R
import com.example.kotlin_prueba.network.CatApi

class CatAdapter(): RecyclerView.Adapter<CatAdapter.SearchViewHolder>(){

    var catList : List<CatlModel> = emptyList<CatlModel>()

    fun setData(list: ArrayList<CatlModel>){
        catList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_cat, parent,false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val cat = catList[position]
        println("Nombre: " + cat.name)
    }

    override fun getItemCount(): Int {
       return catList.size
    }

    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}
