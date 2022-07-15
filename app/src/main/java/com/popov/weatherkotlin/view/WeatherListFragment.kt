package com.popov.weatherkotlin.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.popov.weatherkotlin.databinding.FragmentWeatherListBinding
import com.popov.weatherkotlin.viewmodel.AppState

class WeatherListFragment : Fragment() {

    companion object {
        fun newInstance() = WeatherListFragment()
    }

    lateinit var binding: FragmentWeatherListBinding
    lateinit var viewModel: WeatherListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(WeatherListViewModel::class.java)
        viewModel.getLiveDate().observe(viewLifecycleOwner, object : Observer<AppState> {
            override fun onChanged(t: AppState) {
                renderDate(t)
            }
        })
        viewModel.sentRequest()
    }

    private fun renderDate(appState: AppState) {
        when (appState) {
            is AppState.Error -> {
                /*TODO()*/
            }
            AppState.Loading -> {
                /*TODO()*/
            }
            is AppState.Success -> {
                val result = appState.weatherDate
                binding.cityName.text = result.city.name
                binding.temperatureValue.text = result.temperature.toString
                binding.temperatureLabel.text = result.feelsLike.toString
            }
        }
    }
}