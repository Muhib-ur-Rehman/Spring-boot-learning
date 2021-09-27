package com.example.SpringBootExample1.UnitTests;
import com.example.SpringBootExample1.controller.TestController;
import com.example.SpringBootExample1.model.CourseSB;
import com.example.SpringBootExample1.model.StudentSB;
import com.example.SpringBootExample1.service.CourseService;
import com.example.SpringBootExample1.service.StudntService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
public class UnitTestOfController {

    @Mock
    private WebApplicationContext webApplicationContext;

    @InjectMocks
    private TestController testController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
    }

    @Mock
    StudntService studntService;
    @Mock
    CourseService courseService;
    
    @Test
    void redirectToHomeTest() throws Exception {
        Mockito.when(this.courseService.getAllCourse()).thenReturn(Collections.emptyList());
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
        Mockito.when(this.studntService.addStudent(student)).thenReturn(student);
        Mockito.when(this.courseService.getAllCourse()).thenReturn(listOfCourses);
        mockMvc.perform(post("/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attributeExists("listOfCourse"))
                .andExpect(model().attributeExists("resultOfAdd"));
    }

    @Test
    void viewAllStudentsTest() throws Exception {
        List listOfStudents = new ArrayList();
        listOfStudents.add(new StudentSB());
        Mockito.when(studntService.getAllStudent()).thenReturn(listOfStudents);
        mockMvc.perform(get("/viewAll"))
                .andExpect(status().isOk())
                .andExpect(view().name("fetchStudent"))
                .andExpect(model().attributeExists("listOfStudents"));
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
        Mockito.when(this.studntService.findStudentByRollNum(1)).thenReturn(listOfStudent);
        Mockito.when(this.courseService.getAllCourse()).thenReturn(listOfCourse);
        mockMvc.perform(get("/searchForUpdate").param("rollNum","1"))
                .andExpect(status().isOk())
                .andExpect(view().name("updateStudent"))
                .andExpect(model().attributeExists("listOfStudents"))
                .andExpect(model().attributeExists("listOfCourse"));
    }

    @Test
    void updateStudentRecordTest() throws Exception {
        StudentSB student = new StudentSB();
        student.setName("Ali");
        student.setAge(24);
        student.setRollNum(4);
        student.setListOfCourses(null);
        student.setGender("Male");
        Mockito.when(this.studntService.addStudent(student)).thenReturn(student);
        mockMvc.perform(get("/updateStd"))
                .andExpect(status().isOk())
                .andExpect(view().name("updateUI"))
                .andExpect(model().attributeExists("resultOfUpdate"));
    }

    @Test
    void deleteStudentTest() throws Exception {
        mockMvc.perform(get("/delete"))
                .andExpect(status().isOk())
                .andExpect(view().name("deleteUI"));
    }

    @Test
    void deleteStudentRecordTest() throws Exception {
        List<StudentSB> listOfStudent = new ArrayList<>();
        listOfStudent.add(new StudentSB());
        Mockito.when(studntService.getAllStudent()).thenReturn(listOfStudent);
        mockMvc.perform(get("/DeleteStudent").param("rollNum","1"))
                .andExpect(status().isOk())
                .andExpect(view().name("deleteUI"))
                .andExpect(model().attributeExists("resultOfDelete"));

    }

    @Test
    void searchStudentTest() throws Exception {
        mockMvc.perform(get("/search"))
                .andExpect(status().isOk())
                .andExpect(view().name("searchUI"));
    }

    @Test
    void searchStudentRecordTest() throws Exception {
        List<StudentSB> listOfStudent = new ArrayList<>();
        listOfStudent.add(new StudentSB());
        Mockito.when(studntService.findStudentByRollNum(1)).thenReturn(listOfStudent);
        mockMvc.perform(get("/searchStudent").param("rollNum","1"))
                .andExpect(status().isOk())
                .andExpect(view().name("searchUI"))
                .andExpect(model().attributeExists("listOfStudent"))
                .andExpect(model().attributeExists("resultOfSearch"));

    }
}
