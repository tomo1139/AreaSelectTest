package com.example.tomo.areaselecttest.view.weatherforecast.areasetting

import com.example.tomo.areaselecttest.service.WeatherForecastService

interface WeatherForecastAreaSettingDelegate {
    fun onClickLocationIcon()
    fun onClickAreaName(area: WeatherForecastService.Area)
}