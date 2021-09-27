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
    public StudentDao studentDao;

    public StudntService(StudentDao studentDao){
        this.studentDao = studentDao;
    }


    public StudentSB addStudent(StudentSB studentSB){
        return studentDao.save(studentSB);
    }

    public List<StudentSB> getAllStudent(){
        return studentDao.findAll();
    }

    public List<StudentSB> findStudentByRollNum(int rollNum){
        return studentDao.findByRollNum(rollNum);
    }

    @Transactional
    public void deleteStudent(int rollNum){ studentDao.deleteByRollNum(rollNum);
    }
}
