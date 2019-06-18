package czd.wcssbackend.persistence.mapper;

import czd.wcssbackend.common.model.courseType.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName CourseMapper
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/16 19:03
 */
@Mapper
public interface CourseMapper {

    void insertCourse(@Param("course") Course course);

    void updateCourse(@Param("course")Course course);

    List<Course> listCoursesByteachId(@Param("teacherName")String teacherName);

    List<Course> listCoursesByLocation(@Param("location")String location);

    List<Course> listCoursesByCourseFitAge(@Param("courseFitAge")String courseFitAge);

    List<Course> listCoursesByCourseDirection(@Param("courseDirection")String courseDirection);

    List<Course> listCourses();

    void deleteCourse(@Param("courseId")Integer courseId);

    Course getCourse(@Param("courseId")Integer courseId);



}
