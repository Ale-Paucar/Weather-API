package com.alexispaucar.weather_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentDayDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("datetime")
    private String dateTime;
    @JsonProperty("temp")
    private float temperature;
    @JsonProperty("feelslike")
    private float feelsLike;
    @JsonProperty("humidity")
    private float humidity;
    @JsonProperty("windspeed")
    private float windSpeed;
    @JsonProperty("pressure")
    private float pressure;
    @JsonProperty("uvindex")
    private int uvIndex;
    @JsonProperty("conditions")
    private String conditions;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("sunrise")
    private String sunrise;
    @JsonProperty("sunset")
    private String sunset;

    public CurrentDayDTO() {
    }

    public CurrentDayDTO(String dateTime, float temperature, float feelsLike, float humidity, float windSpeed, float pressure, int uvIndex, String conditions, String icon, String sunrise, String sunset) {
        this.dateTime = dateTime;
        this.temperature = temperature;
        this.feelsLike = feelsLike;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.uvIndex = uvIndex;
        this.conditions = conditions;
        this.icon = icon;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(float feelsLike) {
        this.feelsLike = feelsLike;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(int uvIndex) {
        this.uvIndex = uvIndex;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }
}
