package com.example.SpringBootExample1.IntegrationTests;

import com.example.SpringBootExample1.model.CourseSB;
import com.example.SpringBootExample1.service.CourseService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CourseServiceIntegrationTest {

    @Autowired
    CourseService courseService;

    @Test
    void getAllCourseTest(){
        List<CourseSB> courseList = this.courseService.getAllCourse();
        Assert.assertNotNull(this.courseService.getAllCourse());
        Assert.assertEquals(1,courseList.get(0).getCourseId());
        Assert.assertEquals("CS",courseList.get(0).getCourseCode());
        Assert.assertEquals("Computer Science",courseList.get(0).getCourseName());
        Assert.assertEquals(2,courseList.get(1).getCourseId());
        Assert.assertEquals("BBA",courseList.get(1).getCourseCode());
        Assert.assertEquals("Bussines Administration",courseList.get(1).getCourseName());
    }
}
