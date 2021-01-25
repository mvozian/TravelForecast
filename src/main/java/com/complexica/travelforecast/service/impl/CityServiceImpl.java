package com.complexica.travelforecast.service.impl;

import com.complexica.travelforecast.model.CityEntity;
import com.complexica.travelforecast.repository.CityRepository;
import com.complexica.travelforecast.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    public Optional<CityEntity> getCityEntityByName(String cityName) {
        return repository.findAll().stream()
                .filter(cityEntity -> cityEntity.getName().equals(cityName)).findFirst();
    }
}
