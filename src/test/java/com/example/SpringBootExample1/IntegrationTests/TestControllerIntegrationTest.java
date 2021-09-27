package com.example.SpringBootExample1.IntegrationTests;


import com.example.SpringBootExample1.controller.TestController;
import com.example.SpringBootExample1.model.CourseSB;
import com.example.SpringBootExample1.model.StudentSB;
import com.example.SpringBootExample1.service.StudntService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestControllerIntegrationTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    TestController testController;

    private MockMvc mockMvc;

    @Autowired
    StudntService studntService;
    static Model model;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
    }



    @Test
    void redirectToHomeTest() throws Exception {
        mockMvc.perform(get("/index"))
            .andExpect(status().isOk())
            .andExpect(view().name("home"))
            .andExpect(model().attributeExists("listOfCourse"));
    }

    @Test
    void addStudentTest() throws Exception {
        List listOfCourses = new ArrayList();
        listOfCourses.add(new CourseSB());
        StudentSB student = new StudentSB();
        student.setName("Ali");
        student.setAge(24);
        student.setRollNum(4);
        student.setListOfCourses(null);
        student.setGender("Male");
        mockMvc.perform(post("/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attributeExists("listOfCourse"))
                .andExpect(model().attributeExists("resultOfAdd"))
                .andExpect(model().attribute("resultOfAdd",true));
    }

    @Test
    void viewAllStudentsTest() throws Exception {
        mockMvc.perform(get("/viewAll"))
                .andExpect(status().isOk())
                .andExpect(view().name("fetchStudent"))
                .andExpect(model().attributeExists("listOfStudents"))
                .andExpect(model().attribute("listOfStudents",hasSize(5)));
    }

    @Test
    void updateStudentTest() throws Exception {
        mockMvc.perform(get("/update"))
                .andExpect(status().isOk())
                .andExpect(view().name("updateUI"));
    }

    @Test
    void searchForUpdateTest() throws Exception {
        List<CourseSB> listOfCourse = new ArrayList();
        listOfCourse.add(new CourseSB());
        List<StudentSB> listOfStudent = new ArrayList();
        listOfStudent.add(new StudentSB());
        mockMvc.perform(get("/searchForUpdate").param("rollNum","1"))
                .andExpect(status().isOk())
                .andExpect(view().name("updateStudent"))
                .andExpect(model().attributeExists("listOfStudents"))
                .andExpect(model().attributeExists("listOfCourse"))
                .andExpect(model().attribute("listOfStudents",hasSize(1)))
                .andExpect(model().attribute("listOfCourse",hasSize(6)));
    }

    @Test
    void updateStudentRecordTest() throws Exception {
        StudentSB student = new StudentSB();
        student.setName("Ali");
        student.setAge(24);
        student.setRollNum(4);
        student.setListOfCourses(null);
        student.setGender("Male");
        mockMvc.perform(get("/updateStd"))
                .andExpect(status().isOk())
                .andExpect(view().name("updateUI"))
                .andExpect(model().attributeExists("resultOfUpdate"))
                .andExpect(model().attribute("resultOfUpdate",true));
    }

    @Test
    void deleteStudentTest() throws Exception {
        mockMvc.perform(get("/delete"))
                .andExpect(status().isOk())
                .andExpect(view().name("deleteUI"));
    }

    @Test
    void deleteStudentRecordTest() throws Exception {
        mockMvc.perform(get("/DeleteStudent").param("rollNum","4"))
                .andExpect(status().isOk())
                .andExpect(view().name("deleteUI"))
                .andExpect(model().attributeExists("resultOfDelete"))
                .andExpect(model().attribute("resultOfDelete",true));

    }

    @Test
    void searchStudentTest() throws Exception {
        mockMvc.perform(get("/search"))
                .andExpect(status().isOk())
                .andExpect(view().name("searchUI"));
    }

    @Test
    void searchStudentRecordTest() throws Exception {
        mockMvc.perform(get("/searchStudent").param("rollNum","1"))
                .andExpect(status().isOk())
                .andExpect(view().name("searchUI"))
                .andExpect(model().attributeExists("listOfStudent"))
                .andExpect(model().attributeExists("resultOfSearch"))
                .andExpect(model().attribute("listOfStudent",hasSize(1)))
                .andExpect(model().attribute("resultOfSearch",true));
    }

}
