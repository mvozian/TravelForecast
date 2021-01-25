package com.complexica.travelforecast.provider;

import com.complexica.travelforecast.dto.TravelInfo;
import com.complexica.travelforecast.provider.responsemodel.CurrentWeather;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public final class WeatherProvider {

    @Value("${provider.openweather.url}")
    private String providerUrl;

    @Value("${provider.openweather.apikey}")
    private String providerApiKey;

    private final RestTemplate restTemplate;

    public CurrentWeather getCurrentWeather(TravelInfo travelInfo) {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("serviceUrl", providerUrl);
        valuesMap.put("serviceApiKey", providerApiKey);
        valuesMap.put("city", travelInfo.getCityName());
        valuesMap.put("units", travelInfo.getUnit());
        valuesMap.put("language", travelInfo.getLang());

        //TODO replace with a builder
        var url = "${serviceUrl}?q=${city}&appid=${serviceApiKey}&units=${units}&lang=${language}";
        var sub = new StringSubstitutor(valuesMap);
        var resolvedUrl = sub.replace(url);

        return restTemplate.getForObject(resolvedUrl, CurrentWeather.class);
    }
}
