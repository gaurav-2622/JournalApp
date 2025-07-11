package net.edigest.journalApp.service;

import net.edigest.journalApp.api.response.AppCache;
import net.edigest.journalApp.api.response.WeatherResponse;
import net.edigest.journalApp.constants.PlaceHolders;
import net.edigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String api;

    @Autowired
    private AppCache appCache;

    @Autowired
    private RestTemplate restTemplate;
    public WeatherResponse getWeather(String city){
        String finalAPI = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace(PlaceHolders.CITY,city).replace(PlaceHolders.API_KEY,api);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET,null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }

    //Obviously didnot run bcz there is mo such thing to send bofy in API
//    public WeatherResponse getWeatherPostCall(String city){
//        String finalAPI = API.replace("CITY",city).replace("API_KEY",api);
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set("key","value");
////        String request = {  this is accepted as we send it from postman or we can do is --
////                "userName":"hero",
////                "password":"hero"};
//        User user = User.builder().userName("hero").password("hero").build();
//        HttpEntity<User> httpEntity= new HttpEntity<>(user,httpHeaders);
//
//        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.POST,httpEntity, WeatherResponse.class);
//        WeatherResponse body = response.getBody();
//        return body;
//    }
}
