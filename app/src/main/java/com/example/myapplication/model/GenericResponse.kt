package com.example.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Abhishek Rana
 * @since 9/3/20
 * <h1>GenericResponse</h1>
 * <p>Description of class</p>
 * */

data class GenericResponse<T : Any>(
    @SerializedName("data")
    @Expose
    var data: T? = null,
    @SerializedName("code")
    @Expose
    var code: Int = 0,
    @SerializedName("message")
    @Expose
    var message: String? = null
)
