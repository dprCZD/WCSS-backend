package czd.wcssbackend.persistence.mapper;

import czd.wcssbackend.common.model.courseType.Course;
import czd.wcssbackend.common.model.courseType.CourseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CourseInfoMapper {

    void insertCourseInfo(@Param("courseInfo") CourseInfo courseInfo);

    void updateCourseInfo(@Param("courseInfo")CourseInfo courseInfo);

    List<CourseInfo> listCourseInfosByTeachId(@Param("teacherId")Integer teachId);

    List<CourseInfo> listCourseInfosByStuId(@Param("stuId")Integer stuId);

    List<CourseInfo> listCourseInfosByCourseId(@Param("courseId")Integer courseId);

    List<CourseInfo> listCourseInfos();

    void deleteCourseinfo(@Param("classId")Integer classId);

    CourseInfo getCourseInfo(@Param("classId")Integer classId);
}
