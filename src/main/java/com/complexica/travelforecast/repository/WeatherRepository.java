package com.complexica.travelforecast.repository;

import com.complexica.travelforecast.model.CityEntity;
import com.complexica.travelforecast.model.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {

    List<WeatherEntity> findByCity(CityEntity cityEntity);

}
