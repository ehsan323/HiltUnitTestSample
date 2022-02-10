package com.adjust.unit_test_sample.repository

import com.adjust.unit_test_sample.api.SampleApi
import com.adjust.unit_test_sample.entity.ResponseGeoNames
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


open class SampleRepository @Inject
constructor(private val api: SampleApi) {

    fun getGeoNames(lat: Double, lon: Double): Observable<ResponseGeoNames> {
        return api.getGeoNames(lat.toString(), lon.toString(), "ehsan323")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}
