package com.example.tomo.areaselecttest.viewmodel

import android.databinding.ObservableField
import com.example.tomo.areaselecttest.service.WeatherForecastService
import com.example.tomo.areaselecttest.view.weatherforecast.areasetting.WeatherForecastAreaSettingDelegate
import java.lang.ref.WeakReference

class WeatherForecastAreaSettingViewModel(val wDelegate: WeakReference<WeatherForecastAreaSettingDelegate>) {

    val settingArea = ObservableField<String>("-")

    fun onClickLocationIcon() = wDelegate.get()?.onClickLocationIcon()

    fun onClickSettingArea() = Unit

    fun onClickAreaName(area: WeatherForecastService.Area) = wDelegate.get()?.onClickAreaName(area)
}