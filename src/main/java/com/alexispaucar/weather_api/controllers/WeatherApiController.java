package com.alexispaucar.weather_api.controllers;

import com.alexispaucar.weather_api.dto.WeatherDataDTO;

import com.alexispaucar.weather_api.exceptions.TooManyRequestException;
import com.alexispaucar.weather_api.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.bucket4j.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WeatherApiController {
    private final WeatherService weatherService;
    private final Bucket bucket;

    @Autowired
    public WeatherApiController(WeatherService weatherService, Bucket bucket) {
        this.weatherService = weatherService;
        //inyeccion de bucket en constructor
        this.bucket = bucket;
    }


    @GetMapping("/weather")
    @Cacheable("weather-search")
    public WeatherDataDTO getWeatherData(@RequestParam String city) throws JsonProcessingException {
        if(bucket.tryConsume(1)){
            return weatherService.getWeather(city);
        }else {
            throw new TooManyRequestException("Error, too many requests");
        }
    }
}
