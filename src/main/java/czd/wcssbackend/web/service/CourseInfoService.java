package czd.wcssbackend.web.service;


import czd.wcssbackend.common.model.courseType.Course;
import czd.wcssbackend.common.model.courseType.CourseInfo;

import java.util.List;

public interface CourseInfoService {

    void insertCourseInfo( CourseInfo courseInfo);

    void updateCourseInfo(CourseInfo courseInfo);

    List<CourseInfo> listCourseInfosByTeachId(Integer teachId);

    List<CourseInfo> listCourseInfosByStuId(Integer stuId);

    List<CourseInfo> listCourseInfosByCourseId(Integer courseId);

    List<CourseInfo> listCourseInfos();

    void deleteCourseinfo(Integer classId);

    CourseInfo getCourseInfo(Integer classId);
}
