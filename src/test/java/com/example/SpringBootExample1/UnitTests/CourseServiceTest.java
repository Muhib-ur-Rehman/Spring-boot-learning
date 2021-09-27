package com.example.SpringBootExample1.UnitTests;
import com.example.SpringBootExample1.DAO.CourseDAO;
import com.example.SpringBootExample1.model.CourseSB;
import com.example.SpringBootExample1.service.CourseService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class CourseServiceTest {

    @Mock
    CourseDAO courseDAO;

    @Test
    public void getAllCourseTest(){
        CourseService courseService = new CourseService(courseDAO);
        List<CourseSB> courseList = new ArrayList<>();
        courseList.add(new CourseSB());
        Mockito.when(this.courseDAO.findAll()).thenReturn(courseList);
        Assert.assertNotEquals(0,courseService.getAllCourse().size());
    }
}
