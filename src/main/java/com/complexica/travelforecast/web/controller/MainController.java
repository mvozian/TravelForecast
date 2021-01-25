package com.complexica.travelforecast.web.controller;

import com.complexica.travelforecast.common.Cities;
import com.complexica.travelforecast.common.Language;
import com.complexica.travelforecast.common.Units;
import com.complexica.travelforecast.dto.TravelInfo;
import com.complexica.travelforecast.dto.WeatherInfo;
import com.complexica.travelforecast.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainController {

    private final WeatherService weatherService;

    @GetMapping("/forecast-form")
    public String itineraryForm(Model model) {
        List<WeatherInfo> weatherInfo = weatherService.getAllWeather();

        model.addAttribute("travelInfo", new TravelInfo());
        model.addAttribute("cities", Cities.getCities());
        model.addAttribute("units", Units.getUnits());
        model.addAttribute("languages", Language.getSupportedLanguages());
        model.addAttribute("savedWeather", weatherInfo);
        return "forecast-form";
    }

    @PostMapping("/forecast-form")
    public String itinerarySubmit(@ModelAttribute("travelInfo") TravelInfo travelInfo) {
        weatherService.updateWeather(travelInfo);
        return "redirect:forecast-form";
    }
}
