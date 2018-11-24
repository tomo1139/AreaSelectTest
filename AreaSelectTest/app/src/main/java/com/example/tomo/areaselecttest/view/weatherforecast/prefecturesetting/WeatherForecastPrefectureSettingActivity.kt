package com.example.tomo.areaselecttest.view.weatherforecast.prefecturesetting

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.tomo.areaselecttest.R
import com.example.tomo.areaselecttest.databinding.ActivityWeatherForecastPrefectureSettingBinding
import com.example.tomo.areaselecttest.service.WeatherForecastService

class WeatherForecastPrefectureSettingActivity : AppCompatActivity() {

    private val binding: ActivityWeatherForecastPrefectureSettingBinding by lazy { DataBindingUtil.setContentView<ActivityWeatherForecastPrefectureSettingBinding>(this, R.layout.activity_weather_forecast_prefecture_setting) }
    private val area by lazy { intent.getSerializableExtra(keyArea) as WeatherForecastService.Area }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = area.name
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    companion object {
        private const val keyArea = "keyArea"

        fun newIntent(context: Context, area: WeatherForecastService.Area) = Intent(context, WeatherForecastPrefectureSettingActivity::class.java).also {
            it.putExtra(keyArea, area)
        }
    }

}