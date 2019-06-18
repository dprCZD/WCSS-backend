package czd.wcssbackend.persistence.mapper;


import czd.wcssbackend.common.model.courseType.CourseInfo;
import czd.wcssbackend.common.model.courseType.PaidCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaidCourseMapper {

    void insertPaidCourse(@Param("paidCourse") PaidCourse paidCourse);

    void updatePaidCourse(@Param("paidCourse")PaidCourse paidCourse);

    List<PaidCourse> listPaidCoursesByCourseId(@Param("courseId")Integer courseId);

    List<PaidCourse> listPaidCoursesByParId(@Param("parId")Integer parId);

    List<PaidCourse> listPaidCourses();

    void deletePaidCourse(@Param("paidId")Integer paidId);

    PaidCourse getPaidCourse(@Param("paidId")Integer paidId);
}
