package com.example.tomo.areaselecttest.view.weatherforecast.areasetting

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.location.Geocoder
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import com.example.tomo.areaselecttest.R
import com.example.tomo.areaselecttest.databinding.ActivityWeatherForecastAreaSettingBinding
import com.example.tomo.areaselecttest.extension.showDialogWithAllowingStateLoss
import com.example.tomo.areaselecttest.extension.showShortToast
import com.example.tomo.areaselecttest.util.RequestCode
import com.example.tomo.areaselecttest.view.dialog.TwoChoicesDialogFragment
import com.example.tomo.areaselecttest.viewmodel.WeatherForecastAreaSettingViewModel
import com.google.android.gms.location.*
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.OnPermissionDenied
import permissions.dispatcher.PermissionUtils
import permissions.dispatcher.RuntimePermissions
import java.lang.ref.WeakReference

@RuntimePermissions
class WeatherForecastAreaSettingActivity : AppCompatActivity(), WeatherForecastAreaSettingDelegate, TwoChoicesDialogFragment.Delegate {

    private val binding: ActivityWeatherForecastAreaSettingBinding by lazy { DataBindingUtil.setContentView<ActivityWeatherForecastAreaSettingBinding>(this, R.layout.activity_weather_forecast_area_setting)}
    private val controller: WeatherForecastAreaEpoxyController by lazy {
        WeatherForecastAreaEpoxyController()
    }
    private val viewModel: WeatherForecastAreaSettingViewModel by lazy { WeatherForecastAreaSettingViewModel(WeakReference(this)) }
    private val settingsClient by lazy { LocationServices.getSettingsClient(this) }
    private val fusedLocationClient by lazy { LocationServices.getFusedLocationProviderClient(this) }
    private val locationRequest by lazy { LocationRequest().setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY) }
    private val locationSettingsRequest by lazy { LocationSettingsRequest.Builder().apply { addLocationRequest(locationRequest) }.build() }
    private val locationCallback by lazy {
        object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)
                if (!Geocoder.isPresent()) return
                if (locationResult.locations.size == 0) return
                val location = locationResult.locations[0]
                val geoCoder = Geocoder(this@WeatherForecastAreaSettingActivity)
                val addresses = geoCoder.getFromLocation(location.latitude, location.longitude, 1)
                addresses.firstOrNull()?.let {
                    if (it.countryCode == "JP") {
                        Log.e("dbg", "address: " + it)
                        Log.e("dbg", "adminArea: " + it.adminArea)
                        Log.e("dbg", "subAdminArea: " + it.subAdminArea)
                        Log.e("dbg", "locality: " + it.locality)
                        viewModel.settingArea.set(it.adminArea + it.locality)
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "地域設定"

        binding.recyclerView.adapter = controller.adapter
        controller.setData(viewModel)
    }

    override fun onPause() {
        super.onPause()
        fusedLocationClient.removeLocationUpdates(locationCallback)
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

    override fun onClickLocationIcon() {
        getMyLocationWithPermissionCheck()
    }

    @SuppressLint("MissingPermission")
    @NeedsPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    fun getMyLocation() {
        settingsClient.checkLocationSettings(locationSettingsRequest)
            .addOnSuccessListener {
                fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null)
            }
            .addOnFailureListener {
                TwoChoicesDialogFragment.newInstance(
                    "現在地情報を取得できません",
                    "端末のGPSを有効にしてください",
                    "設定画面",
                    "キャンセル",
                    RequestCode.GPS.ordinal
                ).showDialogWithAllowingStateLoss(supportFragmentManager)
            }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResult(requestCode, grantResults)
    }

    @OnPermissionDenied(Manifest.permission.ACCESS_FINE_LOCATION)
    fun deniedPermission() {
        if (PermissionUtils.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            showShortToast("現在地情報取得に失敗しました")
        } else {
            TwoChoicesDialogFragment.newInstance(
                "現在地情報を取得できません",
                "設定画面 > 許可 から位置情報の権限を許可してください",
                "設定画面",
                "キャンセル",
                RequestCode.AppSetting.ordinal
            ).showDialogWithAllowingStateLoss(supportFragmentManager)
        }
    }

    override fun onClickButton(requestCode: Int, responseCode: Int) {
        if (responseCode == Activity.RESULT_OK) {
            when (requestCode) {
                RequestCode.AppSetting.ordinal -> {
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                        data = Uri.fromParts("package", packageName, null)
                    }
                    startActivity(intent)
                }
                RequestCode.GPS.ordinal -> {
                    val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                    startActivity(intent)
                }
            }
        }
    }

    override fun onClickAreaName() {
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, WeatherForecastAreaSettingActivity::class.java)
    }
}