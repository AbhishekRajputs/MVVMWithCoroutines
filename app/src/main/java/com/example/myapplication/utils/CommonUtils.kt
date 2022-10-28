package com.example.myapplication.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.example.myapplication.base.BaseApp



object CommonUtils {

    var context = BaseApp.getContext()


    fun isNetworkAvailable(): Boolean {
        val connectivity =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivity.activeNetworkInfo
        if (info != null) {
            return info.state == NetworkInfo.State.CONNECTED || info.state == NetworkInfo.State.CONNECTING
        }
        return false
    }
}