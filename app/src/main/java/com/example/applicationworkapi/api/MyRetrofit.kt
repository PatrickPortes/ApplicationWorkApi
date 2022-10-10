package com.example.applicationworkapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MyRetrofit {

    private val retrofit: Retrofit

    fun productApi(): ProductApi{
        return retrofit.create(ProductApi::class.java)
    }

    companion object{
        //Inserir URL da API para requisitar os dados
        private const val BASE_URL = ""

        val myRetrofit: MyRetrofit? = null

        //Requisição da Retrofit em Segundo Plano
        @get:Synchronized
        val instance: MyRetrofit?
            get() {
                if(myRetrofit == null){
                    myRetrofit == MyRetrofit()
                }
                    return myRetrofit
            }
    }

    //Sempre que Inicializar a Classe, a val retrofit inicializa também
    init {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

}