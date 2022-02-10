package com.adjust.unit_test_sample.base

import android.annotation.TargetApi
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.widget.Toast
import dagger.android.support.DaggerAppCompatActivity


import javax.inject.Inject
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.adjust.unit_test_sample.R


abstract class BaseActivity<VM : ViewModel, DB : ViewDataBinding> : AppCompatActivity() {

//    @Inject
//    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var dataBinding: DB
    lateinit var viewModel: VM

    @get:LayoutRes
    protected abstract val layoutResId: Int
    protected abstract val getViewModel: Class<VM>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, layoutResId)
       // viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
        viewModel = ViewModelProvider(this).get(getViewModel)
        dataBinding.executePendingBindings()
        dataBinding.lifecycleOwner = this
    }

fun showMessage(message: String?) {
    if (message != null) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

}