package com.complexica.travelforecast.common;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lombok.AccessLevel.PUBLIC;

@AllArgsConstructor(access = PUBLIC)
public enum Units {

    STANDARD(1, "Standard"), IMPERIAL(2, "Imperial"), METRIC(3, "Metric");

    public final Integer id;
    public final String name;

    public static List<Units> getUnits() {
        return new ArrayList<>(Arrays.asList(Units.STANDARD, Units.IMPERIAL, Units.METRIC));
    }
}
