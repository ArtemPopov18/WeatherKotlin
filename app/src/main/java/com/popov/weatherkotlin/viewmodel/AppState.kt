package com.popov.weatherkotlin.viewmodel

import com.popov.weatherkotlin.domen.Weather

sealed class AppState {
    data class Success(val weatherDate: Weather) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}