package com.example.SpringBootExample1;

import com.example.SpringBootExample1.model.StudentSB;
import com.example.SpringBootExample1.service.StudntService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest(
//        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
//        classes = SpringBootExample1Application.class
//)
//@AutoConfigureMockMvc

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringBootExample1Application.class)
@WebMvcTest(StudntService.class)
class SpringBootExample1ApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudntService studntService;

    @Test
    void abctest() throws Exception {

        StudentSB student = new StudentSB();
        student.setName("Ali");
        student.setAge(24);
        student.setRollNum(4);
        student.setListOfCourses(null);
        student.setGender("Male");

        Mockito.when(studntService.addStudent(student)).thenReturn(student);


        Assert.assertEquals(student, studntService.addStudent(student));
    }

}
