package com.example.tomo.areaselecttest.view.weatherforecast.prefecturesetting

import com.example.tomo.areaselecttest.service.WeatherForecastService

interface WeatherForecastPrefectureSettingDelegate {
    fun onClickPrefecture(prefecture: WeatherForecastService.Prefecture)
}