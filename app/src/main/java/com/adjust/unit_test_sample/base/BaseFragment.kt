package com.adjust.unit_test_sample.base

import android.annotation.TargetApi
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Created by Ehsan Aminifar on 15/09/2017.
 */

abstract class BaseFragment<VM : ViewModel, DB : ViewDataBinding> : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: VM
    lateinit var dataBinding: DB


    @LayoutRes
    protected abstract fun layoutResId(): Int

    abstract fun getViewModel(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, layoutResId(), container, false) as DB
        dataBinding.lifecycleOwner = this
        return dataBinding.root
    }


    fun onError(resId: Int) {
        onError(getString(resId))
    }


    fun onError(message: String?) {
        if (message != null) {
            //showSnackBar(message)
        }
    }


    fun showMessage(message: String?) {
        if (message != null) {
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show()
        }
    }


    fun showMessage(resId: Int) {
        showMessage(getString(resId))
    }


}
