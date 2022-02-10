package com.adjust.unit_test_sample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.adjust.unit_test_sample.R
import com.adjust.unit_test_sample.base.BaseActivity
import com.adjust.unit_test_sample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val layoutResId: Int = R.layout.activity_main
    override val getViewModel: Class<MainViewModel> = MainViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding.viewModel=viewModel

        findViewById<Button>(R.id.btn).setOnClickListener {
            viewModel.showGeoNames(28.36,53.96)
        }

    }

}