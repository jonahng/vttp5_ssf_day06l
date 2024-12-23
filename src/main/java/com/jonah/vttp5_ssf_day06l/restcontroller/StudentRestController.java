package com.jonah.vttp5_ssf_day06l.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jonah.vttp5_ssf_day06l.constant.Constant;
import com.jonah.vttp5_ssf_day06l.model.Student;
import com.jonah.vttp5_ssf_day06l.service.StudentService;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "/api/students", produces = "application/json")
public class StudentRestController {

@Autowired
StudentService studentService;

    @PostMapping(path = {"", "/create"}) //this allows 2 ways to acess the page
    public ResponseEntity<String> create(@RequestBody Student entity){
        //return new ResponseEntity("true", HttpStatus.OK);

        //ok is the status 
        studentService.add(entity);
        return ResponseEntity.ok().body("true");
    }

    @GetMapping("")
    public ResponseEntity<String> findAll() {
        List<Student> students = studentService.findAll(Constant.studentKey);
        JsonArrayBuilder jsonArray = Json.createArrayBuilder();
        for(Student s: students){
            JsonObject jsonObj = Json.createObjectBuilder()
            .add("id", s.getId())
            .add("fullName", s.getFullName())
            .add("email", s.getEmail())
            .add("phoneNumber",s.getPhoneNumber())
            .build();

            jsonArray.add(jsonObj);
        }
        jsonArray.build();
        return ResponseEntity.ok().body(jsonArray.toString());
    }
    
    
}
