package com.adjust.unit_test_sample.view

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.adjust.unit_test_sample.base.BaseViewModel
import com.adjust.unit_test_sample.entity.ResponseGeoNames
import com.adjust.unit_test_sample.repository.SampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sampleRepository: SampleRepository
) : BaseViewModel() {

    val cityName = MutableLiveData<ResponseGeoNames>()


    @SuppressLint("CheckResult")
    fun showGeoNames(lat: Double, lon: Double){
        sampleRepository.getGeoNames(lat,lon)
            .subscribe ({
             cityName.value=it
            },{
                showToast(it.message.toString())
            })
    }

}