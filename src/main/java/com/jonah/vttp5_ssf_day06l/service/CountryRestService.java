package com.jonah.vttp5_ssf_day06l.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jonah.vttp5_ssf_day06l.constant.URL;
import com.jonah.vttp5_ssf_day06l.model.Country;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;

@Service
public class CountryRestService {
    RestTemplate restTemplate = new RestTemplate();

    public List<Country> getCountries(){
        String countryData = restTemplate.getForObject(URL.countryUrl, String.class);
        //System.out.println(countryData);


        JsonReader jReader = Json.createReader(new StringReader(countryData));
        JsonObject jObject = jReader.readObject();
        //the whole set of data received from the api is an object. the data section without the headers is another object. jDataObject is the 
        JsonObject jDataObject = jObject.getJsonObject("data");
        

        List<Country> countries = new ArrayList<>();
        Set<Entry<String,JsonValue>> entries = jDataObject.entrySet();
        for(Entry<String,JsonValue> entry: entries){
            Country c = new Country();
            c.setCode(entry.getKey());
            c.setName(entry.getValue().asJsonObject().getString("country"));
            countries.add(c);
        }

        return null;
    }
}
