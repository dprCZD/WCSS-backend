package czd.wcssbackend.web.service;

import czd.wcssbackend.common.model.courseType.TrialCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName TrialCourseService
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/17 23:17
 */
public interface TrialCourseService {

    void insertTrialCourse(TrialCourse trialCourse);

    void updateTrialCourse(TrialCourse trialCourse);

    List<TrialCourse> listTrialCoursesByParId(String parId);

    List<TrialCourse> listTrialCoursesByCourseId(String courseId);

    List<TrialCourse> listTrialCourses();

    void deleteTrialCourse(Integer trialId);

    TrialCourse getTrialCourse(Integer trialId);
}
