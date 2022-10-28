package com.example.myapplication.ui

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.base.BaseViewModel
import com.example.myapplication.model.GenericResponse
import com.example.myapplication.model.Slots
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author Abhishek Rana
 * @since 8/05/21
 * */
class MainViewModel constructor(private val mainRepository: MainRepository) :
    BaseViewModel() {
    var getTimeSlots = MutableLiveData<GenericResponse<ArrayList<Slots>>>()

    fun getTimeSlots() {
        showLoading.value = true

        if (isValidNetwork()) {
            showLoading.value = true
            launch {
                val result =
                    withContext(Dispatchers.IO) { mainRepository.getTimeSlots() }
                withContext(Dispatchers.Main) {
                    showLoading.value = false
                    apiSuccess(result)
                }
            }
        } else {
            retry.value = { getTimeSlots() }
        }
    }
}