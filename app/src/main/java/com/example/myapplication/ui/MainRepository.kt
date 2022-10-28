package com.example.myapplication.ui

import com.example.myapplication.api.ApiService
import com.example.myapplication.base.UseCaseResult
import com.example.myapplication.model.GenericResponse
import com.example.myapplication.model.Data

/**
 * @author Abhishek Rana
 * @since 8/05/21
 * */

interface MainRepository {
    suspend  fun getTimeSlots(): UseCaseResult<GenericResponse<Data>>
}


class MainRepositoryImpl(private val apiService: ApiService) : MainRepository {

    override suspend fun getTimeSlots(): UseCaseResult<GenericResponse<Data>> {
        return try {
            val result = apiService.getTimeSlots().await()
            UseCaseResult.Success(result)
        } catch (ex: Exception) {
            UseCaseResult.Exception(ex)
        }
    }
}