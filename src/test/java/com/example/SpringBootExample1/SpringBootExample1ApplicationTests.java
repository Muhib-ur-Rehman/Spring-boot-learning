package com.example.SpringBootExample1;
import com.example.SpringBootExample1.service.StudntService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringBootExample1Application.class)
@WebMvcTest(StudntService.class)
class SpringBootExample1ApplicationTests {

}
