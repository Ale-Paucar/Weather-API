package com.alexispaucar.weather_api.service;

import com.alexispaucar.weather_api.dto.CurrentDayDTO;
import com.alexispaucar.weather_api.dto.HourForecastDTO;
import com.alexispaucar.weather_api.dto.WeatherDataDTO;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import java.util.List;

public class WeatherDataDTODeserializer extends JsonDeserializer<WeatherDataDTO> {
    @Override
    public WeatherDataDTO deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        ObjectMapper mapper = new ObjectMapper();
        String[] resolvedAddress = node.get("resolvedAddress").asText().split(",");

        String city = resolvedAddress[0].trim();
        String region = resolvedAddress.length == 2 ? "":resolvedAddress[1].trim();
        String country = resolvedAddress.length == 2 ? resolvedAddress[1].trim() : resolvedAddress[2].trim();
        CurrentDayDTO currentDay = mapper.treeToValue(node.get("currentConditions"), CurrentDayDTO.class);
        List<HourForecastDTO> hourForecastsList = mapper.readValue(
                mapper.treeAsTokens(node.get("days").get(0).get("hours")),
                new TypeReference<List<HourForecastDTO>>() {}
        );
        return new WeatherDataDTO(city,region,country,currentDay,hourForecastsList);
    }
}
