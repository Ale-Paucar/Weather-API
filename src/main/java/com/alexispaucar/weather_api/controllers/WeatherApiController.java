package com.alexispaucar.weather_api.controllers;

import com.alexispaucar.weather_api.dto.WeatherDataDTO;
import com.alexispaucar.weather_api.service.WeatherDataParserService;
import com.alexispaucar.weather_api.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherApiController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherApiController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @GetMapping("/weather")
    @Cacheable("weather-search")
    public WeatherDataDTO getWeatherData(@RequestParam String city) throws JsonProcessingException {
        return weatherService.getWeather(city);
    }
}
