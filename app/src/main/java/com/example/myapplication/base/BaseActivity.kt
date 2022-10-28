package com.example.myapplication.base

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.myapplication.databinding.ContentMainBinding


/**
 * @author Abhishek Rana
 * @since 8/05/21
 * */
abstract class BaseActivity<B : ViewBinding> : AppCompatActivity(), BaseView {

    private val binding by lazy { ContentMainBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.container.addView(getLayout().root, 0)
    }

    abstract fun getLayout(): B

    override fun showLoading() {
        binding.fullScreenLoader.visibility = VISIBLE
    }

    override fun hideLoading() {
        binding.fullScreenLoader.visibility = GONE
    }

    override  fun showError(error: String){

    }
    override  fun showError(message: String, retry: () -> Unit){

    }
    override fun showNoInternetError(retry: () -> Unit){

    }
    override fun showToast(message: String?){

    }
    override  fun showToast(@StringRes message: Int?){

    }
    override fun showRetryPopUp(){

    }
    override fun hideRetryPopUp(){

    }
    override fun showNoConnectionPopUp(type: Int){

    }

}