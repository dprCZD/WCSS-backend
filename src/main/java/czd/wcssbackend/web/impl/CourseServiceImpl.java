package czd.wcssbackend.web.impl;

import czd.wcssbackend.common.model.courseType.Course;
import czd.wcssbackend.persistence.mapper.CourseMapper;
import czd.wcssbackend.web.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName CourseServiceImpl
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/16 20:40
 */
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper mapper;
    @Override
    public void insertCourse(Course course) {
        mapper.insertCourse(course);

    }

    @Override
    public void updateCourse(Course course) {
        mapper.updateCourse(course);

    }

    @Override
    public List<Course> listCoursesByteachId(String teacherName) {
        return mapper.listCoursesByteachId(teacherName);
    }

    @Override
    public List<Course> listCoursesByLocation(String location) {
        return mapper.listCoursesByLocation(location);
    }

    @Override
    public List<Course> listCoursesByCourseFitAge(String courseFitAge) {
        return mapper.listCoursesByCourseFitAge(courseFitAge);
    }

    @Override
    public List<Course> listCoursesByCourseDirection(String courseDirection) {
        return mapper.listCoursesByCourseDirection(courseDirection);
    }

    @Override
    public List<Course> listCourses() {
        return mapper.listCourses();
    }

    @Override
    public void deleteCourse(Integer courseId) {
        mapper.deleteCourse(courseId);
    }

    @Override
    public Course getCourse(Integer courseId) {
        return mapper.getCourse(courseId);
    }
}
