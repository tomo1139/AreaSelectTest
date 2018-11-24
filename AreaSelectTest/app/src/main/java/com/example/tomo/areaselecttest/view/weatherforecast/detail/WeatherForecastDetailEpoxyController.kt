package com.example.tomo.areaselecttest.view.weatherforecast.detail

import com.airbnb.epoxy.TypedEpoxyController
import com.example.tomo.areaselecttest.WeatherForecastDetailDailyBindingModel_

class WeatherForecastDetailEpoxyController: TypedEpoxyController<Unit>() {

    override fun buildModels(data: Unit) {
        WeatherForecastDetailDailyBindingModel_()
            .id(modelCountBuiltSoFar)
            .addTo(this)
    }
}