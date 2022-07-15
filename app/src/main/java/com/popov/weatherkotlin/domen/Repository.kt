package com.popov.weatherkotlin.domen

interface Repository {
    fun getListWeather():List<Weather>
    fun getWeather(lat: Double, lon: Double):Weather
}