package com.adjust.unit_test_sample.api

import com.adjust.unit_test_sample.entity.ResponseGeoNames
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface SampleApi {

    @GET("timezoneJSON")
    fun getGeoNames(@Query("lat") lat: String,
                    @Query("lng") lon: String,
                    @Query("username") username: String): Observable<ResponseGeoNames>
}