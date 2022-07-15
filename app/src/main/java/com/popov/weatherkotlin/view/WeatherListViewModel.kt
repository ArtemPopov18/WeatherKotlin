package com.popov.weatherkotlin.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.popov.weatherkotlin.domen.Repository
import com.popov.weatherkotlin.domen.RepositoryLocalImpl
import com.popov.weatherkotlin.viewmodel.AppState

class WeatherListViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>()

) :
    ViewModel() {

    lateinit var repository: Repository

    fun getLiveDate(): MutableLiveData<AppState> {
        choiceRepository()
        return liveData
    }

    fun choiceRepository() {
        if (isConnection()) {
            repository = RepositoryLocalImpl()
        }
    }

    fun sentRequest() {
        liveData.value = AppState.Loading
        if((1..3).random()==1){
            liveData.postValue(AppState.Error(throw IllegalStateException("нет связи с сервером")))
            }else
        liveData.postValue(AppState.Success(repository.getWeather(55.755826, 37.617299900000035)))
    }

    private fun isConnection(): Boolean {
        return false
    }


}