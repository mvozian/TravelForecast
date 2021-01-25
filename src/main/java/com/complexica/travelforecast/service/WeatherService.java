package com.complexica.travelforecast.service;


import com.complexica.travelforecast.dto.TravelInfo;
import com.complexica.travelforecast.dto.WeatherInfo;

import java.util.List;

public interface WeatherService {

    void updateWeather(TravelInfo travelInfo);

    List<WeatherInfo> getAllWeather();
}
