package com.alexispaucar.weather_api.controllers;

import com.alexispaucar.weather_api.exceptions.TooManyRequestException;
import com.alexispaucar.weather_api.models.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ApiError> handleCityNotFound (HttpClientErrorException  e){
        ApiError apiError = new ApiError();
        apiError.setMessage(e.getMessage());
        apiError.setError("Error: City Not Found");
        apiError.setStatus(HttpStatus.NOT_FOUND.value());
        apiError.setTimestamp(LocalDate.now().toString());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(apiError);
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<ApiError> handleConnectionError (ResourceAccessException  e){
        ApiError apiError = new ApiError();
        apiError.setMessage(e.getMessage());
        apiError.setError("Could not connect to external API");
        apiError.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        apiError.setTimestamp(LocalDate.now().toString());

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE.value()).body(apiError);
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<ApiError> handleServerError (HttpServerErrorException  e){
        ApiError apiError = new ApiError();
        apiError.setMessage(e.getMessage());
        apiError.setError("External API responded with server error");
        apiError.setStatus(HttpStatus.BAD_GATEWAY.value());
        apiError.setTimestamp(LocalDate.now().toString());

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY.value()).body(apiError);
    }

    @ExceptionHandler(TooManyRequestException.class)
    public ResponseEntity<ApiError> handlerTooManyRequests (TooManyRequestException e){
        ApiError apiError = new ApiError();
        apiError.setMessage(e.getMessage());
        apiError.setError("Too Many requests");
        apiError.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
        apiError.setTimestamp(LocalDate.now().toString());

        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS.value()).body(apiError);
    }
}
