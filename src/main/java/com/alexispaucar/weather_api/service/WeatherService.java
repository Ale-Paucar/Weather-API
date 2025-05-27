package com.alexispaucar.weather_api.service;

import com.alexispaucar.weather_api.dto.WeatherDataDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private final ExternalWeatherApiService fetcher;
    private final WeatherDataParserService parser;

    public WeatherService(ExternalWeatherApiService fetcher, WeatherDataParserService parser) {
        this.fetcher = fetcher;
        this.parser = parser;
    }


    public WeatherDataDTO getWeather(String city) throws JsonProcessingException {
        String json = fetcher.fetchWeatherData(city);
        return parser.parseWeatherData(json);
    }
}
