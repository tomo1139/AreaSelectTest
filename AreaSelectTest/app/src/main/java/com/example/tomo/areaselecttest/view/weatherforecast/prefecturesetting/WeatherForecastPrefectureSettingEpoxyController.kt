package com.example.tomo.areaselecttest.view.weatherforecast.prefecturesetting

import com.airbnb.epoxy.TypedEpoxyController
import com.example.tomo.areaselecttest.WeatherForecastPrefectureSettingListItemBindingModel_
import com.example.tomo.areaselecttest.service.WeatherForecastService
import java.lang.ref.WeakReference

class WeatherForecastPrefectureSettingEpoxyController(private val wDelegate: WeakReference<WeatherForecastPrefectureSettingDelegate>): TypedEpoxyController<WeatherForecastService.Area>() {

    override fun buildModels(data: WeatherForecastService.Area) {
        val delegate = wDelegate.get() ?: return
        data.prefectures.forEach {
            WeatherForecastPrefectureSettingListItemBindingModel_()
                .id(modelCountBuiltSoFar)
                .delegate(delegate)
                .prefecture(it)
                .addTo(this)
        }
    }
}