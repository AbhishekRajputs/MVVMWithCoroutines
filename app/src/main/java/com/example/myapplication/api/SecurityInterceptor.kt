package com.example.myapplication.api


import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * @author Abhishek Rana
 * @since 28/04/21
 * */
class SecurityInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        return chain.proceed(request.build())

    }
}