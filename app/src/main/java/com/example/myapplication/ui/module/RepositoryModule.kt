package com.example.myapplication.ui.module

import com.example.myapplication.ui.MainRepository
import com.example.myapplication.ui.MainRepositoryImpl
import org.koin.dsl.module


/**
 * @author Abhishek Rana
 * @since 28/04/21
 * */

val repositoryModule = module {
    // Tells Koin how to create an instance of repository
    factory<MainRepository> { MainRepositoryImpl(get()) }
}