package com.example.tomo.areaselecttest.viewmodel

import com.example.tomo.areaselecttest.view.main.MainDelegate
import java.lang.ref.WeakReference

class MainViewModel(private val wDelegate: WeakReference<MainDelegate>) {

    fun onClickButton1() = wDelegate.get()?.toWeatherForecastAresSetting()
}