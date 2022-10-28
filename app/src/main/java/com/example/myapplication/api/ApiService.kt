package com.example.myapplication.api

import com.example.myapplication.model.GenericResponse
import com.example.myapplication.model.Data
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("product/time-slots")
    fun getTimeSlots(@Field("shop_ids") id: Int = 1) : Deferred<GenericResponse<Data>>

}