package com.example.kotlin_prueba.UI.view

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_prueba.UI.adapter.CatAdapter
import com.example.kotlin_prueba.databinding.ActivityMainBinding
import com.example.kotlin_prueba.UI.viewmodel.CatViewModel

class CatView : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CatViewModel

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CatViewModel::class.java)

        apiService()

    }
    @RequiresApi(Build.VERSION_CODES.M)
    fun apiService() {
        if(isConnected(this)){
            binding.catListRecyclerView.visibility = View.VISIBLE
            binding.title.visibility = View.VISIBLE
            binding.reintentar.visibility  = View.GONE
            binding.catListRecyclerView.layoutManager = LinearLayoutManager(this)
            binding.catListRecyclerView.adapter = CatAdapter()
            viewModel.getCatList()
            viewModel.catList.observe(
                this,
                Observer { list -> (binding.catListRecyclerView.adapter as CatAdapter).setData(list) })

        }else{
            binding.reintentar.visibility  = View.VISIBLE
            binding.reintentar.text = "NO TIENE CONEXIÓN DE INTERNET \n HAGA CLIC PARA REINTENTAR"
            binding.reintentar.setOnClickListener{
                apiService()
            }
        }

    }
    @RequiresApi(Build.VERSION_CODES.M)
    fun isConnected(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }

}