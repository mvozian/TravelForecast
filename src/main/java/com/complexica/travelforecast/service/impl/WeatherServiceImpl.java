package com.complexica.travelforecast.service.impl;

import com.complexica.travelforecast.dto.CityInfo;
import com.complexica.travelforecast.dto.TravelInfo;
import com.complexica.travelforecast.dto.WeatherInfo;
import com.complexica.travelforecast.model.CityEntity;
import com.complexica.travelforecast.model.WeatherEntity;
import com.complexica.travelforecast.provider.WeatherProvider;
import com.complexica.travelforecast.provider.responsemodel.Description;
import com.complexica.travelforecast.repository.CityRepository;
import com.complexica.travelforecast.repository.WeatherRepository;
import com.complexica.travelforecast.service.CityService;
import com.complexica.travelforecast.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherProvider weatherProvider;
    private final WeatherRepository weatherRepository;
    private final CityService cityService;
    private final CityRepository cityRepository;

    @Override
    @Transactional
    public void updateWeather(TravelInfo travelInfo) {
        Optional<CityEntity> existingCityEntity = cityService.getCityEntityByName(travelInfo.getCityName());
        var cityEntity = existingCityEntity.orElseGet(() -> cityRepository.save(new CityEntity(travelInfo.getCityId(), travelInfo.getCityName())));

        var currentWeather = weatherProvider.getCurrentWeather(travelInfo);
        var temperature = currentWeather.getMain().getTemp().intValue();
        var description = currentWeather.getWeather().stream()
                .findFirst().orElseGet(() -> new Description("not available at the moment")).getDescription();

        var weatherEntity = new WeatherEntity(temperature, description, LocalDateTime.now(), cityEntity);
        weatherRepository.save(weatherEntity);
    }

    @Override
    public List<WeatherInfo> getAllWeather() {
        return weatherRepository.findAll().stream()
                .map(weatherEntity -> WeatherInfo.builder()
                        .withId(weatherEntity.getId())
                        .withTemperature(weatherEntity.getTemperature())
                        .withDescription(weatherEntity.getDescription())
                        .withWeatherDate(weatherEntity.getWeatherDate())
                        .withCityInfo(new CityInfo(weatherEntity.getCity().getId(), weatherEntity.getCity().getName()))
                        .build())
                .collect(Collectors.toList());
    }
}
