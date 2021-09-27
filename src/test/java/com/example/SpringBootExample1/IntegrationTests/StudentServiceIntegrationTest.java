package com.example.SpringBootExample1.IntegrationTests;


import com.example.SpringBootExample1.DAO.StudentDao;
import com.example.SpringBootExample1.model.StudentSB;
import com.example.SpringBootExample1.service.CourseService;
import com.example.SpringBootExample1.service.StudntService;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentServiceIntegrationTest {

    @Autowired
    StudntService studntService;

    @Autowired
    StudentDao studentDao;

    @Test
    @Order(1)
    void addStudentTest(){
        StudentSB student = new StudentSB();
        student.setName("Ali");
        student.setAge(24);
        student.setRollNum(4);
        student.setListOfCourses(null);
        student.setGender("Male");
        Assert.assertEquals(student,this.studntService.addStudent(student));
    }

    @Test
    @Order(2)
    void getAllStudentTest(){
        Assert.assertNotNull(this.studntService.getAllStudent());
        Assert.assertNotEquals(0,this.studntService.getAllStudent().size());
    }

    @Test
    @Order(3)
    void findStudentByRollNumTest(){
        Assert.assertNotNull(this.studntService.findStudentByRollNum(4));
        Assert.assertNotEquals(0,this.studntService.findStudentByRollNum(4).size());
    }

    @Test
    @Order(4)
    void deleteStudentTest(){
        this.studntService.deleteStudent(4);
        Assert.assertEquals(0,this.studntService.findStudentByRollNum(4).size());
    }
}
