package com.popov.weatherkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.popov.weatherkotlin.databinding.ActivityMainBinding
import com.popov.weatherkotlin.view.WeatherListFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, WeatherListFragment.newInstance()).commit()
        }
    }
}