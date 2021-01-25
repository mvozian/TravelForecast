package com.complexica.travelforecast.common;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lombok.AccessLevel.PUBLIC;

@AllArgsConstructor(access = PUBLIC)
public enum Cities {

    LONDON(1, "London"), MOSCOW(2, "Moscow"), TOKYO(3, "Tokyo");

    public final Integer id;
    public final String name;

    public static List<Cities> getCities() {
        return new ArrayList<>(Arrays.asList(Cities.LONDON, Cities.MOSCOW, Cities.TOKYO));
    }
}
