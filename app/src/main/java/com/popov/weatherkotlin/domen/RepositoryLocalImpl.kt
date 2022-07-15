package com.popov.weatherkotlin.domen

import android.content.res.Resources
import com.popov.weatherkotlin.viewmodel.AppState

class RepositoryLocalImpl : Repository {
    override fun getListWeather(): List<Weather> {
        Thread {
            Thread.sleep(200L)
        }.start()
        return listOf(Weather())
    }

    override fun getWeather(lat: Double, lon: Double): Weather {
        return Weather()
    }

}