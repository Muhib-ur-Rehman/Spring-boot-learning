package com.example.SpringBootExample1.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class StudentSB {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    private String name;
    private   int rollNum;
    private int age;
    private String gender;

    @ManyToMany(fetch = FetchType.EAGER)
    public List<CourseSB> listOfCourses;

    @Override
    public String toString() {
        return "StudentSB{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", rollNum=" + rollNum +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", listOfCourses=" + listOfCourses +
                '}';
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNum() {
        return rollNum;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<CourseSB> getListOfCourses() {
        return listOfCourses;
    }

    public void setListOfCourses(ArrayList<CourseSB> listOfCourses) {
        this.listOfCourses = listOfCourses;
    }

    public StudentSB(int studentId, String name, int rollNum, int age, String gender, ArrayList<CourseSB> listOfCourses) {
        this.studentId = studentId;
        this.name = name;
        this.rollNum = rollNum;
        this.age = age;
        this.gender = gender;
        this.listOfCourses = listOfCourses;
    }

    public StudentSB() {
    }
}
