package com.example.tomo.areaselecttest.view.main

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tomo.areaselecttest.R
import com.example.tomo.areaselecttest.databinding.ActivityMainBinding
import com.example.tomo.areaselecttest.view.weatherforecast.areasetting.WeatherForecastAreaSettingActivity
import com.example.tomo.areaselecttest.view.weatherforecast.detail.WeatherForecastDetailActivity
import com.example.tomo.areaselecttest.viewmodel.MainViewModel
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity(), MainDelegate {

    private val binding: ActivityMainBinding by lazy { DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main ) }
    private val viewModel: MainViewModel by lazy { MainViewModel(WeakReference(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun toWeatherForecastAresSetting() = startActivity(WeatherForecastAreaSettingActivity.newIntent(this))
    override fun toWeatherForecastDetail() = startActivity(WeatherForecastDetailActivity.newIntent(this))
}
