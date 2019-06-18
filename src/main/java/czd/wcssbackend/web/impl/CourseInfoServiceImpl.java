package czd.wcssbackend.web.impl;

import czd.wcssbackend.common.model.courseType.Course;
import czd.wcssbackend.common.model.courseType.CourseInfo;
import czd.wcssbackend.persistence.mapper.CourseInfoMapper;
import czd.wcssbackend.persistence.mapper.CourseMapper;
import czd.wcssbackend.web.service.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName CourseInfoServiceImpl
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/17 18:39
 */
public class CourseInfoServiceImpl implements CourseInfoService {

    @Autowired
    CourseInfoMapper mapper;

    @Override
    public void insertCourseInfo(CourseInfo courseInfo) {
        mapper.insertCourseInfo(courseInfo);

    }

    @Override
    public void updateCourseInfo(CourseInfo courseInfo) {
        mapper.updateCourseInfo(courseInfo);
    }

    @Override
    public List<CourseInfo> listCourseInfosByTeachId(Integer teachId) {
        return mapper.listCourseInfosByTeachId(teachId);
    }

    @Override
    public List<CourseInfo> listCourseInfosByStuId(Integer stuId) {
        return mapper.listCourseInfosByStuId(stuId);
    }

    @Override
    public List<CourseInfo> listCourseInfosByCourseId(Integer courseId) {
        return mapper.listCourseInfosByCourseId(courseId);
    }

    @Override
    public List<CourseInfo> listCourseInfos() {
        return mapper.listCourseInfos();
    }

    @Override
    public void deleteCourseinfo(Integer classId) {
        mapper.deleteCourseinfo(classId);
    }

    @Override
    public CourseInfo getCourseInfo(Integer classId) {
        return mapper.getCourseInfo(classId);
    }
}
