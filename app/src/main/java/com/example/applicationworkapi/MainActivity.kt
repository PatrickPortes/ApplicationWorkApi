package com.example.applicationworkapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RemoteCallbackList
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationworkapi.api.MyRetrofit
import com.example.applicationworkapi.model.Product
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewProducts: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewProducts = rvProducts
        recyclerViewProducts.layoutManager = LinearLayoutManager(this)
        getData()
    }

    //Método Responsável por Trazer os Dados do Servidor
    private fun getData(){

        val call: Call<List<Product>> = MyRetrofit.instance?.productApi()?.getProductApi() as Call<List<Product>>

        //Criando uma Fila de Requisições
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                val adapter = ProductAdapter(this@MainActivity, response.body()?.toList() as List<Product>)
                recyclerViewProducts.adapter = adapter
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}