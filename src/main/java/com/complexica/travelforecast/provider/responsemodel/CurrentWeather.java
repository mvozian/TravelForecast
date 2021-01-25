package com.complexica.travelforecast.provider.responsemodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@JsonInclude(NON_NULL)
public class CurrentWeather {

    private List<Description> weather;
    private Temperature main;
}
