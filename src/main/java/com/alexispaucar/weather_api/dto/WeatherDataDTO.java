package com.alexispaucar.weather_api.dto;

import com.alexispaucar.weather_api.service.WeatherDataDTODeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.util.List;

@JsonDeserialize(using = WeatherDataDTODeserializer.class)
public class WeatherDataDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String city;
    private String region;
    private String country;
    private CurrentDayDTO currentDay;
    private List<HourForecastDTO> hourForecastsList;

    public WeatherDataDTO(String city, String region, String country, CurrentDayDTO currentDay, List<HourForecastDTO> hourForecastsList) {
        this.city = city;
        this.region = region;
        this.country = country;
        this.currentDay = currentDay;
        this.hourForecastsList = hourForecastsList;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CurrentDayDTO getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(CurrentDayDTO currentDay) {
        this.currentDay = currentDay;
    }

    public List<HourForecastDTO> getHourForecastsList() {
        return hourForecastsList;
    }

    public void setHourForecastsList(List<HourForecastDTO> hourForecastsList) {
        this.hourForecastsList = hourForecastsList;
    }
}
