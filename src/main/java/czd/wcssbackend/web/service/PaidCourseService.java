package czd.wcssbackend.web.service;

import czd.wcssbackend.common.model.courseType.CourseInfo;
import czd.wcssbackend.common.model.courseType.PaidCourse;

import java.util.List;

public interface PaidCourseService {

    void insertPaidCourse( PaidCourse paidCourse);

    void updatePaidCourse(PaidCourse paidCourse);

    List<PaidCourse> listPaidCoursesByCourseId(Integer courseId);

    List<PaidCourse> listPaidCoursesByParId(Integer parId);

    List<PaidCourse> listPaidCourses();

    void deletePaidCourse(Integer paidId);

    PaidCourse getPaidCourse(Integer paidId);
}
