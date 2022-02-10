package com.adjust.unit_test_sample.view

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.adjust.unit_test_sample.base.RxImmediateSchedulerRule
import com.adjust.unit_test_sample.entity.ResponseGeoNames
import com.adjust.unit_test_sample.repository.SampleRepository
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import junit.framework.Assert
import junit.framework.TestCase
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

class MainViewModelTest{

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    @Mock
    lateinit var observerName: Observer<ResponseGeoNames>

    @Mock
    lateinit var mRepository: SampleRepository

    @Mock
    lateinit var observerToast: Observer<String>


    lateinit var mainViewModel: MainViewModel

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mainViewModel = MainViewModel(mRepository)
    }

    @Test
    fun doSearchResultSuccessWithData() {

        // GIVEN
        val search = ResponseGeoNames("Iran")
        val observable = Observable.just(search)

        // WHEN
        mainViewModel.cityName.observeForever(observerName)
        whenever(mRepository.getGeoNames(28.36,53.96)).thenReturn(observable)
        mainViewModel.showGeoNames(28.36,53.96)

        // THEN
        val captor = ArgumentCaptor.forClass(ResponseGeoNames::class.java)
        Mockito.verify(observerName).onChanged(captor.capture())
        MatcherAssert.assertThat(captor.value?.countryName, CoreMatchers.`is`(search.countryName))
        MatcherAssert.assertThat(captor.value?.countryCode, CoreMatchers.`is`(search.countryCode))
    }

    @Test
    fun doSearch_errorResponse_InvokesNoNetworkCalls() {

        // GIVEN
        val error = Observable.error<Exception>(Exception("No network here"))

        // WHEN
        mainViewModel.toast.observeForever(observerToast)
        Mockito.doReturn(error).whenever(mRepository).getGeoNames(28.36,53.96)
        mainViewModel.showGeoNames(28.36,53.96)

        // THEN
        val captor = ArgumentCaptor.forClass(String::class.java)
        Mockito.verify(observerToast).onChanged(captor.capture())
        MatcherAssert.assertThat(captor.value, CoreMatchers.`is`("No network here"))
    }

}