package com.example.myapplication.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * @author Abhishek Rana
 * @since 11/2/20
 * <h1>BaseFragment</h1>
 * <p>Description of class</p>
 * */
abstract class BaseFragment : Fragment(), BaseView {
    private var baseView: BaseView? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseView) {
            baseView = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayout(), container, false)
    }

    @LayoutRes
    protected abstract fun getLayout(): Int


    override fun showError(error: String) {
        baseView?.showError(error)
    }

    override fun showError(message: String, retry: () -> Unit) {
        baseView?.showError(message, retry)
    }

    override fun showLoading() {
        baseView?.showLoading()
    }

    override fun hideLoading() {
        baseView?.hideLoading()
    }

    override fun showNoInternetError(retry: () -> Unit) {
        baseView?.showNoInternetError(retry)
    }

    override fun showToast(message: String?) {
        baseView?.showToast(message)
    }

    override fun showToast(message: Int?) {
        baseView?.showToast(message)
    }

    override fun showRetryPopUp() {
        baseView?.showRetryPopUp()
    }

    override fun hideRetryPopUp() {
        baseView?.hideRetryPopUp()
    }

    override fun showNoConnectionPopUp(type: Int) {
        baseView?.showNoConnectionPopUp(type)
    }

    fun onBackPressed(){
        
    }

    interface OnBackPressed {
        fun onBackPressed()
    }

}