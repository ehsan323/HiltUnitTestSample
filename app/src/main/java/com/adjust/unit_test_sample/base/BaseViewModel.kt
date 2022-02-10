package com.adjust.unit_test_sample.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

     val toast = MutableLiveData<String>()

    fun showToast(message: String) {
        toast.postValue(message)
    }

}
