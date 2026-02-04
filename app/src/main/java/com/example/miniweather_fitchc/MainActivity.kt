package com.example.miniweather_fitchc

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miniweather_fitchc.Utilities.WeatherService

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var tvGreeting: TextView = findViewById(R.id.tvGreeting)
        var tvCity: TextView = findViewById(R.id.tvCity)
        var ivWeather: ImageView = findViewById(R.id.ivWeather)
        var tvTemperature: TextView = findViewById(R.id.tvTemperature)
        var tvWeather: TextView = findViewById(R.id.tvWeather)

        val ws = WeatherService()
        val cities = ws.getCities()
        tvCity.text = cities[0]

        val weather = ws.getWeather(cities[0])
        tvTemperature.text = "${weather.temperature}"
        tvGreeting.text = "Bienvenido"

        when (weather.weatherType) {
            "snowy" -> {
                tvWeather.text = getText(R.string.snowy)
                ivWeather.setImageResource(R.drawable.ic_snowy)
            }

            "rainy" -> {
                tvWeather.text = getText(R.string.rainy)
                ivWeather.setImageResource(R.drawable.ic_snowy)
            }

            "cloudy" -> {
                tvWeather.text = getText(R.string.cloudy)
                ivWeather.setImageResource(R.drawable.ic_cloudy)
            }

            "sunny" -> {
                tvWeather.text = getText(R.string.sunny)
                ivWeather.setImageResource(R.drawable.ic_sunny)
            }

            "windy" -> {
                tvWeather.text = getText(R.string.windy)
                ivWeather.setImageResource(R.drawable.ic_windy)
            }
        }

    }
}