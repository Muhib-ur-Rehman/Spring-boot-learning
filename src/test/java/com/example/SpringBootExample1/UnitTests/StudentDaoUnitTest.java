package com.example.SpringBootExample1.UnitTests;


import com.example.SpringBootExample1.DAO.StudentDao;
import com.example.SpringBootExample1.model.StudentSB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class StudentDaoUnitTest {

    @Mock
    StudentDao studentDao;


    @Test
    void findByRollNumTest(){
        List<StudentSB> studentList = new ArrayList<>();
        StudentSB student = new StudentSB();
        student.setRollNum(1);
        student.setStudentId(10);
        student.setAge(25);
        student.setGender("Male");
        student.setName("Ali");
        studentList.add(student);
        Mockito.when(studentDao.findByRollNum(1)).thenReturn(studentList);
        List<StudentSB> searchedStudents = this.studentDao.findByRollNum(1);
        Assertions.assertNotNull(searchedStudents);
        Assertions.assertEquals(student.getStudentId(),searchedStudents.get(0).getStudentId());
        Assertions.assertEquals(student.getRollNum(),searchedStudents.get(0).getRollNum());
        Assertions.assertEquals(student.getName(),searchedStudents.get(0).getName());
        Assertions.assertEquals(student.getGender(),searchedStudents.get(0).getGender());
    }

    @Test
    void deleteByRollNum(){
        this.studentDao.deleteByRollNum(1);
    }

}
