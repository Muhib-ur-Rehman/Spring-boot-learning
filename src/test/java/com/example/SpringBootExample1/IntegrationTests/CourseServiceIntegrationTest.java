package com.example.SpringBootExample1.IntegrationTests;

import com.example.SpringBootExample1.service.CourseService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseServiceIntegrationTest {

    @Autowired
    CourseService courseService;

    @Test
    void getAllCourseTest(){
        Assert.assertNotEquals(0,this.courseService.getAllCourse().size());
        Assert.assertNotNull(this.courseService.getAllCourse());
    }
}
