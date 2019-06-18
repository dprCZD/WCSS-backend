package czd.wcssbackend;

import czd.wcssbackend.common.model.courseType.Course;
import czd.wcssbackend.persistence.mapper.CourseMapper;
import czd.wcssbackend.web.impl.CourseServiceImpl;
import czd.wcssbackend.web.impl.ParentServiceImpl;
import czd.wcssbackend.web.service.CourseService;
import czd.wcssbackend.web.service.ParentService;
import czd.wcssbackend.web.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.Service;
import java.sql.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WcssBackendApplicationTests {


    @Test
    public void contextLoads() {
        CourseService service=new CourseServiceImpl();
        Course course=new Course();
        course.setCourseDirection("English");
        course.setCourseFitAge(6);
        course.setCourseLocation("Shanghai");
        course.setCourseName("English");
        course.setCoursePrice((double)666);
        course.setCourseTime(new Date(System.currentTimeMillis()));
        course.setCourseUserStars(6.8);
        course.setTeacherName("");
        service.insertCourse(course);
        course.setCourseDirection("Chinese");
        service.updateCourse(course);
        List<Course> list=service.listCourses();
        list=service.listCoursesByLocation("Shanghai");
    }

}
