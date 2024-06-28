package br.com.okayamafilho.testeaikosptrans.api

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    val TOKEN = "7283c7558f5fee16beb01a03a6fb41d8b301461d7503d5744e483cbbeb3bb2f8"

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        val request = requestBuilder.addHeader(
            "Authorization", "Bearer $TOKEN",
        ).build()
        return chain.proceed(request)
    }
}

//class AuthInterceptor(private val headers: Map<String, String>) : Interceptor {
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val originalRequest = chain.request()
//        val requestBuilder = originalRequest.newBuilder()
//
//        for ((key, value) in headers) {
//            requestBuilder.addHeader(key, value)
//        }
//
//        val request = requestBuilder.build()
//        return chain.proceed(request)
//    }
//}