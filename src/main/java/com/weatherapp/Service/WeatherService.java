package com.weatherapp.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.weatherapp.DTO.WeatherResponse;

@Service
public class WeatherService {

    private static final String API_KEY = "952c1ab5fd9492752aa0a2f04a31d272";
    private static final String BASE_URL =
        "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    public WeatherResponse getWeather(String city) {
        try {
            String url = String.format(BASE_URL, city, API_KEY);

            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

            JsonObject json = JsonParser.parseString(response).getAsJsonObject();

            if (json.has("cod") && json.get("cod").getAsInt() != 200) {
                return new WeatherResponse(city, 0, null, null, json.get("message").getAsString());
            }

            double temp = json.getAsJsonObject("main").get("temp").getAsDouble();
            String description = json.getAsJsonArray("weather")
                .get(0).getAsJsonObject().get("description").getAsString();
            String icon = json.getAsJsonArray("weather")
                .get(0).getAsJsonObject().get("icon").getAsString();

            String iconUrl = "http://openweathermap.org/img/wn/" + icon + "@2x.png";
            return new WeatherResponse(city, temp, description, iconUrl, null);

        } catch (Exception e) {
            return new WeatherResponse(city, 0, null, null, "Error fetching weather: " + e.getMessage());
        }
    }
}
