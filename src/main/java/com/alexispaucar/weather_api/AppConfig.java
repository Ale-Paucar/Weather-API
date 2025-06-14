package com.alexispaucar.weather_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bucket4j.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    //Se define Bean a bucket para definir un ancho de banda con limite de 20 peticiones por minuto de manera global
    @Bean
    public Bucket bucket() {
        Bandwidth limit = Bandwidth.classic(20, Refill.greedy(20, Duration.ofMinutes(1)));
        return Bucket.builder().addLimit(limit).build();
    }

}
