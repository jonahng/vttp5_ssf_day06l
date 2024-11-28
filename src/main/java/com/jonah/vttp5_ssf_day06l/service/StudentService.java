package com.jonah.vttp5_ssf_day06l.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonah.vttp5_ssf_day06l.model.Student;
import com.jonah.vttp5_ssf_day06l.repository.ListRepo;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;

@Service
public class StudentService {
    @Autowired
    ListRepo studentRepo;


    //write CRUD functions

    public void add(Student student){
        studentRepo.rightPush(("students"), student.toString());
    }

    public List<Student> findAll(String redisKey){
        List<String> students = studentRepo.getList(redisKey);
        List<Student> studentRecords = new ArrayList<>();

        //JsonArrayBuilder jab = Json.createArrayBuilder();

        //use json-p to cast to list of students json object
        for(String raw: students){
            String[] data = raw.split(",");
            
            
            //day 16 ppt 12
           /*  JsonObject jo = Json.createObjectBuilder() //careful not to import the google jsonobject, use jakarta.
            .add("id", Integer.parseInt(data[0]))
            .add("fullName", data[1])
            .add("email", data[2])
            .add("phoneNumber", data[3])
            .build();
            jab.add(jo); */            //put json object into array using arraybuilder, day 16 ppt 7
             //add json object to json array
            Student s = new Student(Integer.parseInt(data[0]),data[1],data[2],data[3]);
            studentRecords.add(s);
            

        }
        //build the array


        return  studentRecords;
    }
}
