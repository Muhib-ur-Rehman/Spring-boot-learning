package com.example.SpringBootExample1.UnitTests;
import com.example.SpringBootExample1.DAO.StudentDao;
import com.example.SpringBootExample1.model.StudentSB;
import com.example.SpringBootExample1.service.StudntService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(SpringExtension.class)
public class StudentServiceTest {

    @Mock
    public StudentDao studentDao;

    @Test
    void addStudentTest() throws Exception {
        StudntService studntService = new StudntService(studentDao);
        StudentSB student = new StudentSB();
        student.setName("Ali");
        student.setAge(24);
        student.setRollNum(4);
        student.setListOfCourses(null);
        student.setGender("Male");
        Mockito.when(studentDao.save(student)).thenReturn(student);
        Assert.assertEquals(student, studntService.addStudent(student));
    }

    @Test
    void getAllStudentTest(){
        StudntService studntService = new StudntService(studentDao);
        List<StudentSB> list = new ArrayList<>();
        list.add(new StudentSB());
        Mockito.when(studentDao.findAll()).thenReturn(list);
        Assert.assertNotEquals(0,studntService.getAllStudent().size());
    }

    @Test
    void findStudentByRollNumTest(){
        StudntService studntService = new StudntService(studentDao);
        StudentSB student = new StudentSB();
        student.setRollNum(1);
        List<StudentSB> list = new ArrayList<>();
        list.add(student);
        Mockito.when(studentDao.findByRollNum(1)).thenReturn((list));
        Assert.assertNotEquals(0,studntService.findStudentByRollNum(1).size());
    }

    @Test
    void deleteStudent(){
        StudntService studntService = new StudntService(studentDao);
        studntService.deleteStudent(1);
    }
}
