package com.example.SpringBootExample1.service;

import com.example.SpringBootExample1.DAO.CourseDAO;
import com.example.SpringBootExample1.model.CourseSB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CourseService {
    @Autowired
    public CourseDAO courseDAO;

    public CourseService(CourseDAO courseDAO){
        this.courseDAO = courseDAO;
    }

    public List<CourseSB> getAllCourse(){
        return this.courseDAO.findAll();
    }
}
