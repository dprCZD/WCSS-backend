package czd.wcssbackend.web.service;



import czd.wcssbackend.common.model.courseType.Course;

import java.util.List;

/**
 * @ClassName CourseService
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/16 20:38
 */
public interface CourseService {

    void insertCourse( Course course);

    void updateCourse(Course course);

    List<Course> listCoursesByteachId(String teacherName);

    List<Course> listCoursesByLocation(String location);

    List<Course> listCoursesByCourseFitAge(String courseFitAge);

    List<Course> listCoursesByCourseDirection(String courseDirection);

    List<Course> listCourses();

    void deleteCourse(Integer courseId);

    Course getCourse(Integer courseId);

}
