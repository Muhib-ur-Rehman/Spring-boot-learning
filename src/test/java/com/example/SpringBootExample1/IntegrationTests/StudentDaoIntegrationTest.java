package com.example.SpringBootExample1.IntegrationTests;

import com.example.SpringBootExample1.DAO.StudentDao;
import com.example.SpringBootExample1.model.StudentSB;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class StudentDaoIntegrationTest {

    @Autowired
    StudentDao studentDao;

    @Test
    void findByRollNumTest(){
        List<StudentSB> listOfStudent = this.studentDao.findByRollNum(1);
        Assert.assertNotNull(listOfStudent);
        Assert.assertNotEquals(0,listOfStudent.size());
        Assert.assertEquals(1,listOfStudent.get(0).getRollNum());
        Assert.assertEquals("Waqas",listOfStudent.get(0).getName());
        Assert.assertEquals(24,listOfStudent.get(0).getAge());
        Assert.assertEquals(28,listOfStudent.get(0).getStudentId());
    }

    @Test
    @Transactional
    void deleteByRollNumTest(){
        List<StudentSB> before = this.studentDao.findByRollNum(4);
        System.out.println(before.get(0));
        this.studentDao.deleteByRollNum(4);
        List<StudentSB> after = this.studentDao.findByRollNum(4);
        Assertions.assertNotNull(before);
        Assertions.assertEquals(0,after.size());
    }
}
