package com.example.myapplication.base

import android.app.Application
import com.example.myapplication.module.networkModule
import com.example.myapplication.module.repositoryModule
import com.example.myapplication.module.viewModelModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * @author Abhishek Rana
 * @since 8/05/21
 * */
class BaseApp : Application() {

    companion object {
        private lateinit var INSTANCE: BaseApp
        fun getContext(): BaseApp {
            return INSTANCE
        }
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        Timber.plant(Timber.DebugTree())
        startKoin {
            androidLogger()
            androidContext(this@BaseApp)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
    }


}