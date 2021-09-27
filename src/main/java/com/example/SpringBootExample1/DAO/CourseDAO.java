package com.example.SpringBootExample1.DAO;

import com.example.SpringBootExample1.model.CourseSB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDAO extends JpaRepository<CourseSB,Integer> {

}
