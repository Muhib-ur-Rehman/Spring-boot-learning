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
        studentList.add(new StudentSB());
        Mockito.when(studentDao.findByRollNum(1)).thenReturn(studentList);
        Assertions.assertNotNull(this.studentDao.findByRollNum(1));
    }

    @Test
    void deleteByRollNum(){
        this.studentDao.deleteByRollNum(1);
    }

}
