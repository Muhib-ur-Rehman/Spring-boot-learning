package com.example.SpringBootExample1.IntegrationTests;


import com.example.SpringBootExample1.controller.TestController;
import com.example.SpringBootExample1.model.CourseSB;
import com.example.SpringBootExample1.model.StudentSB;
import com.example.SpringBootExample1.service.StudntService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@SpringBootTest
public class TestControllerIntegrationTest {

    @Autowired
    TestController testController;
    @Autowired
    StudntService studntService;
    static Model model;

    @BeforeAll
    static void init(){
        model=new Model() {
            @Override
            public Model addAttribute(String s, Object o) {
                return null;
            }

            @Override
            public Model addAttribute(Object o) {
                return null;
            }

            @Override
            public Model addAllAttributes(Collection<?> collection) {
                return null;
            }

            @Override
            public Model addAllAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public Model mergeAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public boolean containsAttribute(String s) {
                return false;
            }

            @Override
            public Object getAttribute(String s) {
                return null;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };
    }

    @Test
    void redirectToHomeTest(){
        Assertions.assertEquals("home",this.testController.redirectToHome(model));
    }

    @Test
    void addStudentTest(){
        ArrayList<CourseSB> listOfCourses = new ArrayList<>();
        listOfCourses.add(new CourseSB(1,"CS","Computer Science"));
        StudentSB student = new StudentSB();
        student.setName("Ali");
        student.setAge(24);
        student.setRollNum(4);
        student.setListOfCourses(null);
        student.setGender("Male");
        this.testController.addStudent(student,model);
        Assertions.assertEquals(student.getStudentId(),this.testController.studntService.findStudentByRollNum(student.getRollNum()).get(0).getStudentId());
    }


}
