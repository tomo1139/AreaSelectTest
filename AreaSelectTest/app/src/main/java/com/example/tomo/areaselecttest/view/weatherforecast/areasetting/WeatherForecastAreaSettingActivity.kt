package com.example.tomo.areaselecttest.view.weatherforecast.areasetting

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tomo.areaselecttest.R
import com.example.tomo.areaselecttest.databinding.ActivityWeatherForecastAreaSettingBinding

class WeatherForecastAreaSettingActivity : AppCompatActivity() {

    private val binding: ActivityWeatherForecastAreaSettingBinding by lazy { DataBindingUtil.setContentView<ActivityWeatherForecastAreaSettingBinding>(this, R.layout.activity_weather_forecast_area_setting)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, WeatherForecastAreaSettingActivity::class.java)
    }
}