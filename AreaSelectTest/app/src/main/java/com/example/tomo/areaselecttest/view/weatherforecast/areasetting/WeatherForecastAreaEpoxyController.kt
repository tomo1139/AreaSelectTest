package com.example.tomo.areaselecttest.view.weatherforecast.areasetting

import com.airbnb.epoxy.TypedEpoxyController
import com.example.tomo.areaselecttest.WeahterForecastAreaSettingHeaderBindingModel_
import com.example.tomo.areaselecttest.viewmodel.WeatherForecastAreaSettingViewModel

class WeatherForecastAreaEpoxyController: TypedEpoxyController<WeatherForecastAreaSettingViewModel>() {

    override fun buildModels(viewModel: WeatherForecastAreaSettingViewModel) {

        WeahterForecastAreaSettingHeaderBindingModel_()
            .id(modelCountBuiltSoFar)
            .viewModel(viewModel)
            .addTo(this)
    }
}