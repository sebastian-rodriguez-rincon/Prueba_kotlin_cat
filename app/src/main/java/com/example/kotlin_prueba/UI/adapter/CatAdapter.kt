package com.example.kotlin_prueba.UI.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.kotlin_prueba.DataFuncionality.CatlModel
import com.example.kotlin_prueba.databinding.CardCatBinding

class CatAdapter() : RecyclerView.Adapter<CatAdapter.SearchViewHolder>() {

    var catList: List<CatlModel> = emptyList<CatlModel>()
    private lateinit var context: Context

    fun setData(list: ArrayList<CatlModel>) {
        catList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        context = parent.context
        val binding = CardCatBinding.inflate(LayoutInflater.from(context), parent, false)
        return SearchViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val url = "https://cdn2.thecatapi.com/images/"
        val cat = catList[position]
        holder.binding.name.text = "Nombre: " + cat.name
        holder.binding.intelligence.text = "Inteligencia: " + cat.intelligence
        holder.binding.origin.text = "Pais de origen: " + cat.origin

        Glide.with(context)
            .load(url + cat.reference_image_id + ".jpg")
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .centerCrop()
            .into(holder.binding.image)

    }

    override fun getItemCount(): Int {
        return catList.size
    }

    inner class SearchViewHolder(val binding: CardCatBinding) :
        RecyclerView.ViewHolder(binding.root)
}
