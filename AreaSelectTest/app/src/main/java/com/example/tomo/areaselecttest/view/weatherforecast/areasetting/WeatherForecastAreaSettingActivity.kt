package com.example.tomo.areaselecttest.view.weatherforecast.areasetting

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.tomo.areaselecttest.R
import com.example.tomo.areaselecttest.databinding.ActivityWeatherForecastAreaSettingBinding

class WeatherForecastAreaSettingActivity : AppCompatActivity() {

    private val binding: ActivityWeatherForecastAreaSettingBinding by lazy { DataBindingUtil.setContentView<ActivityWeatherForecastAreaSettingBinding>(this, R.layout.activity_weather_forecast_area_setting)}
    private val controller: WeatherForecastAreaEpoxyController by lazy {
        WeatherForecastAreaEpoxyController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.recyclerView.adapter = controller.adapter
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
        fun newIntent(context: Context) = Intent(context, WeatherForecastAreaSettingActivity::class.java)
    }
}