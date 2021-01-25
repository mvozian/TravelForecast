package com.complexica.travelforecast.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PUBLIC;

@Data
@RequiredArgsConstructor(access = PUBLIC)
public final class TravelInfo {

    private Long cityId;
    private String cityName;
    private String unit;
    private String lang;
}
