package com.example.tomo.areaselecttest.view.weatherforecast.areasetting

import com.airbnb.epoxy.TypedEpoxyController
import com.example.tomo.areaselecttest.WeahterForecastAreaSettingHeaderBindingModel_
import com.example.tomo.areaselecttest.WeatherForecastAreaSelectListItemBindingModel_
import com.example.tomo.areaselecttest.service.WeatherForecastService
import com.example.tomo.areaselecttest.viewmodel.WeatherForecastAreaSettingViewModel

class WeatherForecastAreaSettingEpoxyController: TypedEpoxyController<WeatherForecastAreaSettingViewModel>() {

    override fun buildModels(viewModel: WeatherForecastAreaSettingViewModel) {

        WeahterForecastAreaSettingHeaderBindingModel_()
            .id(modelCountBuiltSoFar)
            .viewModel(viewModel)
            .addTo(this)

        WeatherForecastService.getSettingAreaData().toList().forEach {
            WeatherForecastAreaSelectListItemBindingModel_()
                .id(modelCountBuiltSoFar)
                .viewModel(viewModel)
                .area(it)
                .addTo(this)
        }
    }
}