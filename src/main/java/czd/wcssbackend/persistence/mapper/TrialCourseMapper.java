package czd.wcssbackend.persistence.mapper;

import czd.wcssbackend.common.model.courseType.Course;
import czd.wcssbackend.common.model.courseType.TrialCourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName TrialCourseMapper
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/17 23:05
 */
@Mapper
public interface TrialCourseMapper {

    void insertTrialCourse(@Param("trialCourse") TrialCourse trialCourse);

    void updateTrialCourse(@Param("trialCourse")TrialCourse trialCourse);

    List<TrialCourse> listTrialCoursesByParId(@Param("parId")String parId);

    List<TrialCourse> listTrialCoursesByCourseId(@Param("courseId")String courseId);

    List<TrialCourse> listTrialCourses();

    void deleteTrialCourse(@Param("trialId")Integer trialId);

    TrialCourse getTrialCourse(@Param("trialId")Integer trialId);
}
