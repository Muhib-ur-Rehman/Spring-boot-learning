package com.example.SpringBootExample1.DAO;

import com.example.SpringBootExample1.model.StudentSB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<StudentSB,Integer> {
    public List<StudentSB> findByRollNum(int rollNum);

    public void deleteByRollNum(int rollNum);
}
