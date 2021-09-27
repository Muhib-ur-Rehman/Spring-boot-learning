package com.example.SpringBootExample1.UnitTests;
import com.example.SpringBootExample1.controller.TestController;
import com.example.SpringBootExample1.model.CourseSB;
import com.example.SpringBootExample1.model.StudentSB;
import com.example.SpringBootExample1.service.CourseService;
import com.example.SpringBootExample1.service.StudntService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@ExtendWith(SpringExtension.class)
public class unitTestOfController {

    @Mock
    StudntService studntService;
    @Mock
    CourseService courseService;
    private static Model model;
    static MockHttpServletRequest request ;
    static TestController testController;

    @BeforeAll
    public static void init(){
        request = new MockHttpServletRequest();
        model= new Model() {
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
        TestController testController = new TestController(studntService,courseService);
        List listOfCourses = new ArrayList();
        listOfCourses.add(new CourseSB());
        Mockito.when(this.courseService.getAllCourse()).thenReturn(listOfCourses);
        Assert.assertEquals("home",testController.redirectToHome(model));
    }

    @Test
    void addStudentTest(){
        TestController testController = new TestController(studntService,courseService);
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
        Assert.assertEquals("home",testController.addStudent(student,model));
    }

    @Test
    void viewAllStudentsTest(){
        TestController testController = new TestController(studntService,courseService);
        List listOfStudents = new ArrayList();
        listOfStudents.add(new StudentSB());
        Mockito.when(studntService.getAllStudent()).thenReturn(listOfStudents);
        Assert.assertEquals("fetchStudent",testController.viewAllStudents(model));
    }

    @Test
    void updateStudentTest(){
        TestController testController = new TestController(studntService,courseService);
//        Mockito.when(this.testController.updateStudent()).thenReturn("updateUI");
        Assert.assertEquals("updateUI",testController.updateStudent());
    }

    @Test
    void searchForUpdateTest(){
        TestController testController = new TestController(studntService,courseService);
        List<CourseSB> listOfCourse = new ArrayList();
        listOfCourse.add(new CourseSB());
        List<StudentSB> listOfStudent = new ArrayList();
        listOfStudent.add(new StudentSB());
        request.addParameter("rollNum","1");
        Mockito.when(this.studntService.findStudentByRollNum(1)).thenReturn(listOfStudent);
        Mockito.when(this.courseService.getAllCourse()).thenReturn(listOfCourse);
        Assert.assertEquals("updateStudent",testController.searchForUpdate(request,model));
    }

    @Test
    void updateStudentRecordTest(){
        TestController testController = new TestController(studntService,courseService);
        StudentSB student = new StudentSB();
        student.setName("Ali");
        student.setAge(24);
        student.setRollNum(4);
        student.setListOfCourses(null);
        student.setGender("Male");
        Mockito.when(this.studntService.addStudent(student)).thenReturn(student);
        Assert.assertEquals("updateUI",testController.updateStudentRecord(student,model));
    }

    @Test
    void deleteStudentTest(){
        TestController testController = new TestController(studntService,courseService);
//        Mockito.when(this.testController.deleteStudent()).thenReturn("deleteUI");
        Assert.assertEquals("deleteUI",testController.deleteStudent());
    }

    @Test
    void deleteStudentRecordTest(){
        TestController testController = new TestController(studntService,courseService);
        List<StudentSB> listOfStudent = new ArrayList<>();
        listOfStudent.add(new StudentSB());
        request.addParameter("rollNum","1");
        Mockito.when(studntService.getAllStudent()).thenReturn(listOfStudent);
        Assert.assertEquals("deleteUI",testController.deleteStudentRecord(request,model));
    }

    @Test
    void searchStudentTest(){
        TestController testController = new TestController(studntService,courseService);
//        Mockito.when(this.testController.searchStudent()).thenReturn("searchUI");
        Assert.assertEquals("searchUI",testController.searchStudent());
    }

    @Test
    void searchStudentRecordTest(){
        TestController testController = new TestController(studntService,courseService);
        List<StudentSB> listOfStudent = new ArrayList<>();
        listOfStudent.add(new StudentSB());
        request.addParameter("rollNum","1");
        Mockito.when(studntService.findStudentByRollNum(1)).thenReturn(listOfStudent);
        Assert.assertEquals("searchUI",testController.searchStudentRecord(request,model));
    }
}
