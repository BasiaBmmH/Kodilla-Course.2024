package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WeatherForecastTest {

    private Temperatures temperaturesMock;
    private WeatherForecast weatherForecast;

    @BeforeEach
    void setUp() {

        temperaturesMock = mock(Temperatures.class);

        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);

        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        weatherForecast = new WeatherForecast(temperaturesMock);
    }

    @Test
    void testCalculateForecastWithMock() {
        //Given
//        Map<String, Double> temperaturesMap = new HashMap<>();
//        temperaturesMap.put("Rzeszow", 25.5);
//        temperaturesMap.put("Krakow", 26.2);
//        temperaturesMap.put("Wroclaw", 24.8);
//        temperaturesMap.put("Warszawa", 25.2);
//        temperaturesMap.put("Gdansk", 26.1);
//        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
//        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCalculateAverageTemperature() {
        // When
        double averageTemperature = weatherForecast.avarageTemperature();

        // Then
        assertEquals(25.56, averageTemperature);
    }

    @Test
    void testCalculateMedianTemperature() {
        // When
        double medianTemperature = weatherForecast.medianTemperature();

        // Then
        assertEquals(25.5, medianTemperature);
    }
}
