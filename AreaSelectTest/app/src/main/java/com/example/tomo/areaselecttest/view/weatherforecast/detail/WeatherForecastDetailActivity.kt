package com.example.tomo.areaselecttest.view.weatherforecast.detail

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.tomo.areaselecttest.R
import com.example.tomo.areaselecttest.databinding.ActivityWeatherForecastDetailBinding

class WeatherForecastDetailActivity: AppCompatActivity() {

    private val binding: ActivityWeatherForecastDetailBinding by lazy { DataBindingUtil.setContentView<ActivityWeatherForecastDetailBinding>(this, R.layout.activity_weather_forecast_detail) }
    private val controller: WeatherForecastDetailEpoxyController by lazy {
        WeatherForecastDetailEpoxyController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""

        binding.recyclerView.adapter = controller.adapter
        controller.setData(Unit)
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
        fun newIntent(context: Context) = Intent(context, WeatherForecastDetailActivity::class.java)
    }
}