package com.example.SpringBootExample1.service;

import com.example.SpringBootExample1.DAO.StudentDao;
import com.example.SpringBootExample1.model.StudentSB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class StudntService {
    @Autowired
    private StudentDao studentDao;
    public StudentSB addStudent(StudentSB studentSB){
        return this.studentDao.save(studentSB);
    }

    public List<StudentSB> getAllStudent(){
        return this.studentDao.findAll();
    }

    public List<StudentSB> findStudentByRollNum(int rollNum){
        return this.studentDao.findByRollNum(rollNum);
    }

    @Transactional
    public void deleteStudent(int rollNum){ this.studentDao.deleteByRollNum(rollNum);
    }
}
