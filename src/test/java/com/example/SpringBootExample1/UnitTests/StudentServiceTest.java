package com.example.SpringBootExample1.UnitTests;
import com.example.SpringBootExample1.DAO.StudentDao;
import com.example.SpringBootExample1.model.StudentSB;
import com.example.SpringBootExample1.service.StudntService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
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
        student.setStudentId(21);
        student.setName("Ali");
        student.setAge(24);
        student.setRollNum(4);
        student.setListOfCourses(null);
        student.setGender("Male");
        Mockito.when(studentDao.save(student)).thenReturn(student);
        StudentSB savedStudent = studntService.addStudent(student);
        Assert.assertEquals(student.getStudentId(), savedStudent.getStudentId());
        Assert.assertEquals(student.getRollNum(), savedStudent.getRollNum());
        Assert.assertEquals(student.getName(), savedStudent.getName());
        Assert.assertEquals(student.getAge(), savedStudent.getAge());
        Assert.assertEquals(student.getGender(), savedStudent.getGender());
    }

    @Test
    void getAllStudentTest(){
        StudntService studntService = new StudntService(studentDao);
        List<StudentSB> list = new ArrayList<>();
        list.add(new StudentSB(1,"Ali",1,24,"Male",null));
        list.add(new StudentSB(2,"Ahmed",2,25,"Male",null));
        list.add(new StudentSB(3,"Hasan",3,26,"Male",null));
        Mockito.when(studentDao.findAll()).thenReturn(list);
        List<StudentSB> listOfSearchedStudents = studntService.getAllStudent();
        Assertions.assertEquals(list,listOfSearchedStudents);
        Assertions.assertEquals(list.size(),listOfSearchedStudents.size());
        Assertions.assertEquals(list.get(0).getStudentId(),listOfSearchedStudents.get(0).getStudentId());
        Assertions.assertEquals(list.get(0).getRollNum(),listOfSearchedStudents.get(0).getRollNum());
        Assertions.assertEquals(list.get(1).getName(),listOfSearchedStudents.get(1).getName());
        Assertions.assertEquals(list.get(1).getAge(),listOfSearchedStudents.get(1).getAge());
        Assertions.assertEquals(list.get(2).getName(),listOfSearchedStudents.get(2).getName());
    }

    @Test
    void findStudentByRollNumTest(){
        StudntService studntService = new StudntService(studentDao);
        StudentSB student = new StudentSB();
        student.setRollNum(1);
        student.setStudentId(10);
        student.setAge(25);
        student.setGender("Male");
        student.setName("Ali");
        List<StudentSB> list = new ArrayList<>();
        list.add(student);
        Mockito.when(studentDao.findByRollNum(1)).thenReturn((list));
        List<StudentSB> searchedStudentsList = studntService.findStudentByRollNum(1);
        Assert.assertEquals(list.get(0).getRollNum(),searchedStudentsList.get(0).getRollNum());
        Assert.assertEquals(list.get(0).getStudentId(),searchedStudentsList.get(0).getStudentId());
        Assert.assertEquals(list.get(0).getName(),searchedStudentsList.get(0).getName());
        Assert.assertEquals(list.get(0).getAge(),searchedStudentsList.get(0).getAge());
    }

    @Test
    void deleteStudent(){
        StudntService studntService = new StudntService(studentDao);
        studntService.deleteStudent(1);
    }
}
