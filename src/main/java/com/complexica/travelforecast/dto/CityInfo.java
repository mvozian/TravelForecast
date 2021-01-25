package com.complexica.travelforecast.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import static lombok.AccessLevel.PUBLIC;

@Data
@AllArgsConstructor(access = PUBLIC)
public final class CityInfo {

    private final Long id;
    private final String name;
}
