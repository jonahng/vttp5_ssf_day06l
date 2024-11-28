package com.jonah.vttp5_ssf_day06l.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jonah.vttp5_ssf_day06l.model.Student;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;

@Service
public class StudentRestService {
    
    @Autowired //cannot autowire!
    RestTemplate restTemplate;

    private static String studentUrl = "http://localhost:3000/api/students";

    public List<Student> getAllStudents(){

       ResponseEntity<String> data = restTemplate.getForEntity(studentUrl, String.class);
        //day 16- slide 9 and 7
        JsonReader jReader = Json.createReader(new StringReader(data.toString()));
        JsonObject jObject = jReader.readObject();
        JsonArray jArray = jObject.asJsonArray();

        Set<Entry<String, JsonValue>> entries = jObject.entrySet();


        //THIS JSON-P
        List<Student> students = new ArrayList<>();
        for(Entry<String, JsonValue> entry: entries){
            Student s = new Student();
            s.setId((Integer.parseInt(entry.getValue().asJsonObject().getString("id"))));
            s.setFullName((Integer.parseInt(entry.getValue().asJsonObject().getString("fullName"))));
            s.setEmail((Integer.parseInt(entry.getValue().asJsonObject().getString("email"))));
            s.setPhoneNumber((Integer.parseInt(entry.getValue().asJsonObject().getString("phoneNumber"))));
            students.add(s);
        }


        return null;
    }
}
