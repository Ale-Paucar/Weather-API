package com.alexispaucar.weather_api.service;

import com.alexispaucar.weather_api.dto.WeatherDataDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WeatherDataParserService {
    private final ObjectMapper objectMapper;


    public WeatherDataParserService(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }


    public WeatherDataDTO parseWeatherData(String jsonWeatherData) throws JsonProcessingException {
        WeatherDataDTO data = objectMapper.readValue(jsonWeatherData, WeatherDataDTO.class);
        return data;
    }


}
