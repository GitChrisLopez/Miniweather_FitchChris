package com.example.miniweather_fitchc.Utilities

import com.example.miniweather_fitchc.Domain.Weather

class WeatherService {
    fun getCities(): Array<String>{
        return arrayOf("Ciudad de Mexico", "Londres", "Paris", "Ciudad Obregon", "Guadalajara", "Monterrey")
    }

    private fun generateWeather(): Weather{
        val temp = (-10 .. 50).random()
        val weatherTypes = arrayOf("snowy","stormy","rainy", "windy", "cloudy", "sunny")

        var weatherNumber = -1
        when(temp){
            in -10 ..  0-> weatherNumber = 0
            in 1 .. 18 -> weatherNumber = (0..3).random()
            in 19 .. 25 -> weatherNumber = (3 ..5 ).random()
            in 26 .. 30 -> weatherNumber = (4 ..5 ).random()
            else -> weatherNumber = 5
        }

        val weather = Weather(temp, weatherTypes[weatherNumber])
        return weather
    }

    fun getWeather(city: String): Weather{
        return generateWeather();
    }

}