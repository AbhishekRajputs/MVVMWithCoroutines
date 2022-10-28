package com.example.myapplication.ui.module


import com.example.myapplication.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 * @author Abhishek Rana
 * @since 28/04/21
 * */
val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}