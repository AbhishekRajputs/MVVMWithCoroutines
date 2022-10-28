package com.example.myapplication.module


import com.example.myapplication.api.ApiService
import com.example.myapplication.api.SecurityInterceptor
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


const val BASE_URL="http://18.221.17.130/GroceryConnection/api/"


val networkModule = module {
    // The Retrofit service using our custom HTTP client instance as a singleton
    single {
        createWebService()
    }
}

private fun makeRetrofit(okHttpClient: OkHttpClient): Retrofit? {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
}

private fun makeOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    //add the interceptor for logging the curl commands
    return OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(SecurityInterceptor())
        .readTimeout(20, TimeUnit.SECONDS)
        .cache(null)
        .build()
}

/* function to build our Retrofit service */
fun createWebService(): ApiService {
    val okHttpClient = makeOkHttpClient()
    val client = makeRetrofit(okHttpClient)
    return client?.create(ApiService::class.java)!!
}