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

import java.util.List;

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
        StudentSB savedStudent = this.studntService.addStudent(student);
        Assert.assertEquals(student.getName(),savedStudent.getName());
        Assert.assertEquals(student.getRollNum(),savedStudent.getRollNum());
        Assert.assertEquals(student.getAge(),savedStudent.getAge());
        Assert.assertEquals(student.getGender(),savedStudent.getGender());
    }

    @Test
    @Order(2)
    void getAllStudentTest(){
        List<StudentSB> listOfSearchedStudents = this.studntService.getAllStudent();
        Assert.assertNotNull(listOfSearchedStudents);
        Assert.assertNotEquals(0,listOfSearchedStudents);
        Assert.assertEquals(4,listOfSearchedStudents.get(listOfSearchedStudents.size()-1).getRollNum());
        Assert.assertEquals("Ali",listOfSearchedStudents.get(listOfSearchedStudents.size()-1).getName());
        Assert.assertEquals(24,listOfSearchedStudents.get(listOfSearchedStudents.size()-1).getAge());
        Assert.assertEquals("Male",listOfSearchedStudents.get(listOfSearchedStudents.size()-1).getGender());
    }

    @Test
    @Order(3)
    void findStudentByRollNumTest(){
        List<StudentSB> listOfSearchedStudent = this.studntService.findStudentByRollNum(4);
        Assert.assertNotNull(listOfSearchedStudent);
        Assert.assertNotEquals(0,listOfSearchedStudent.size());
        Assert.assertEquals(4,listOfSearchedStudent.get(0).getRollNum());
        Assert.assertEquals(24,listOfSearchedStudent.get(0).getAge());
        Assert.assertEquals("Ali",listOfSearchedStudent.get(0).getName());
        Assert.assertEquals("Male",listOfSearchedStudent.get(0).getGender());
    }

    @Test
    @Order(4)
    void deleteStudentTest(){
        this.studntService.deleteStudent(4);
        Assert.assertEquals(0,this.studntService.findStudentByRollNum(4).size());
    }
}
