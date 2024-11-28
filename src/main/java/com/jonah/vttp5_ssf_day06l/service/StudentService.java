package com.jonah.vttp5_ssf_day06l.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonah.vttp5_ssf_day06l.model.Student;
import com.jonah.vttp5_ssf_day06l.repository.ListRepo;

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

        //use json-p to cast to list of students json object

        return null;
    }
}
