package com.complexica.travelforecast.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PUBLIC;

@Data
@AllArgsConstructor(access = PUBLIC)
@Builder(builderClassName = "Builder", setterPrefix = "with")
public final class WeatherInfo {

    private final Long id;
    private final Integer temperature;
    private final String description;
    private final LocalDateTime weatherDate;
    private final CityInfo cityInfo;
}
