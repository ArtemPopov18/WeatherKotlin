package com.popov.weatherkotlin.domen

data class Weather(
    val city: City = getDefaultCity(),
    val temperature: Int = 15,
    val feelsLike: Int = 15
)

data class City(
    val name: String,
    val lat: Double,
    val lon: Double
)


fun getDefaultCity() = City("Москва", 55.755826, 37.617299900000035)

