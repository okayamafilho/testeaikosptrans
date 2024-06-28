package br.com.okayamafilho.testeaikosptrans.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitCustom {

    val spTransAPI by lazy {
        Retrofit.Builder()
            .baseUrl("http://api.olhovivo.sptrans.com.br/v2.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().build()
//                     .addInterceptor(AuthInterceptor()).build()
            )
            .build()
            .create(ISPTransAPI::class.java)
    }

}

//fun createRetrofitInstance(): Retrofit {
//    val TOKEN = "d0b25b85cb8b11e619ed435b0044acf824638456da1ce3f94064ce6cd815f9fd"
//
//    val headers = mapOf(
//        "Authorization" to "Bearer your_token",
//        "Custom-Header-1" to "value1",
//        "Custom-Header-2" to "value2"
//    )
//
//    val client = OkHttpClient.Builder()
//        .addInterceptor(AuthInterceptor(headers))
//        .build()
//
//    return Retrofit.Builder()
//        .baseUrl("http://api.olhovivo.sptrans.com.br/v2.1/")
//        .client(client)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//}