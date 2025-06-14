package com.alexispaucar.weather_api.exceptions;

public class TooManyRequestException extends RuntimeException{
    public TooManyRequestException(String message){
        super(message);
    }
}
