package com.example.SpringBootExample1.service;

import com.example.SpringBootExample1.DAO.CourseDAO;
import com.example.SpringBootExample1.model.CourseSB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CourseService {
    @Autowired
    private CourseDAO courseDAO;
    public List<CourseSB> getAllCourse(){
//        this.courseDAO.save(new CourseSB(1,"AA","aaaaaaaaaaaaaaaaaa"));
        return this.courseDAO.findAll();
    }
}
