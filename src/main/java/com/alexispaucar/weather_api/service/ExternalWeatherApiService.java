package com.alexispaucar.weather_api.service;


import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@Service

public class ExternalWeatherApiService {
    @Value("${weather.api.key}")
    private String apiKey;
    @Value("${weather.api.baseURL}")
    private String baseURL;

    private final RestTemplate restTemplate;


    public ExternalWeatherApiService(RestTemplate restTemplate) {
        this.restTemplate=restTemplate;

    }


    public String fetchWeatherData(String city){

        String url = baseURL + city + "?key=" +apiKey;
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (RestClientException e) {

            System.err.println("Error al obtener el clima: " + e.getMessage());
            throw new RuntimeException("Error al obtener el clima: " + e.getMessage(), e);
        }
    }
}
