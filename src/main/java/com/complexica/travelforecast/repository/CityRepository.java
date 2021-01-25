package com.complexica.travelforecast.repository;

import com.complexica.travelforecast.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long> {

}
