package com.complexica.travelforecast.service;

import com.complexica.travelforecast.model.CityEntity;

import java.util.Optional;

public interface CityService {

    Optional<CityEntity> getCityEntityByName(String cityName);
}
