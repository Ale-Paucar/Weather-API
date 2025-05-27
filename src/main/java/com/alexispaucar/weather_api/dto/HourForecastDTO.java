package com.alexispaucar.weather_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HourForecastDTO {
    @JsonProperty("datetime")
    private String time;
    @JsonProperty("temp")
    private float temperature;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("precipprob")
    private float precipProb;
    @JsonProperty("conditions")
    private String conditions;

    public HourForecastDTO() {
    }

    public HourForecastDTO(String time, float temperature, String icon, float precipProb, String conditions) {
        this.time = time;
        this.temperature = temperature;
        this.icon = icon;
        this.precipProb = precipProb;
        this.conditions = conditions;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public float getPrecipProb() {
        return precipProb;
    }

    public void setPrecipProb(float precipProb) {
        this.precipProb = precipProb;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
}
