package com.example.SpringBootExample1.controller;

import com.example.SpringBootExample1.model.CourseSB;
import com.example.SpringBootExample1.model.StudentSB;
import com.example.SpringBootExample1.service.CourseService;
import com.example.SpringBootExample1.service.StudntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@Component
public class TestController {
    @Autowired
    public StudntService studntService;
    @Autowired
    public CourseService courseService;

    public TestController(StudntService studntService,CourseService courseService){
        this.studntService=studntService;
        this.courseService=courseService;
    }

    @RequestMapping("/home")
    public String redirectToHome(Model model){
        model.addAttribute("listOfCourse",this.courseService.getAllCourse());
        return "home";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute StudentSB studentSB,Model model){
        this.studntService.addStudent(studentSB);
        model.addAttribute("resultOfAdd",true);
        model.addAttribute("listOfCourse",this.courseService.getAllCourse());
        return "home";
    }

    @RequestMapping("/viewAll")
    public String viewAllStudents(Model model){
        model.addAttribute("listOfStudents",this.studntService.getAllStudent());
        return "fetchStudent";
    }

    @RequestMapping("/update")
    public String updateStudent(){
        return "updateUI";
    }

    @RequestMapping("/searchForUpdate")
    public String searchForUpdate(HttpServletRequest request,Model model){
        List<StudentSB> searchedStudent = this.studntService.findStudentByRollNum(Integer.parseInt(request.getParameter("rollNum")));
        System.out.println(searchedStudent.toString());
        if(searchedStudent.size() <=0){
            model.addAttribute("resultOfSearch" , false);
            return "updateUI";
        }
        model.addAttribute("listOfStudents",searchedStudent);
        model.addAttribute("listOfCourse",this.courseService.getAllCourse());
        return "updateStudent";
    }

    @RequestMapping("/updateStd")
    public String updateStudentRecord(@ModelAttribute StudentSB student,Model model){
        System.out.println(student.toString());
        StudentSB updated=this.studntService.addStudent(student);
        if (updated != null){
            model.addAttribute("resultOfUpdate" , true);
        }
        else {
            model.addAttribute("resultOfUpdate",false);
        }
        return "updateUI";
    }

    @RequestMapping("/delete")
    public String deleteStudent(){
        return "deleteUI";
    }

    @RequestMapping("/DeleteStudent")
    public String deleteStudentRecord(HttpServletRequest request,Model model){
        List<StudentSB> beforeDelete = this.studntService.getAllStudent();
        this.studntService.deleteStudent(Integer.parseInt(request.getParameter("rollNum")));
        List<StudentSB> afterDelete = this.studntService.getAllStudent();
        if (beforeDelete.size() != afterDelete.size()){
            model.addAttribute("resultOfDelete",true);
            return "deleteUI";
        }
        model.addAttribute("resultOfDelete" , false);
        return "deleteUI";
    }

    @RequestMapping("/search")
    public String searchStudent(){
        return "searchUI";
    }

    @RequestMapping("searchStudent")
    public String searchStudentRecord (HttpServletRequest request , Model model){
        List<StudentSB> searchedStudent = this.studntService.findStudentByRollNum(Integer.parseInt(request.getParameter("rollNum")));
        if (searchedStudent.size()<=0){
            model.addAttribute("resultOfSearch",false);
            return "searchUI";
        }
        model.addAttribute("listOfStudent",searchedStudent);
        model.addAttribute("resultOfSearch" , true);
        return "searchUI";
    }
}
