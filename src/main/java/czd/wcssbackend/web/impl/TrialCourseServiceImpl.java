package czd.wcssbackend.web.impl;

import czd.wcssbackend.common.model.courseType.TrialCourse;
import czd.wcssbackend.persistence.mapper.TrialCourseMapper;
import czd.wcssbackend.web.service.TrialCourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName TrialCourseServiceImpl
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/17 23:18
 */
public class TrialCourseServiceImpl implements TrialCourseService {

    @Autowired
    TrialCourseMapper mapper;
    @Override
    public void insertTrialCourse(TrialCourse trialCourse) {
        mapper.insertTrialCourse(trialCourse);
    }

    @Override
    public void updateTrialCourse(TrialCourse trialCourse) {
        mapper.updateTrialCourse(trialCourse);
    }

    @Override
    public List<TrialCourse> listTrialCoursesByParId(String parId) {
        return mapper.listTrialCoursesByParId(parId);
    }

    @Override
    public List<TrialCourse> listTrialCoursesByCourseId(String courseId) {
        return mapper.listTrialCoursesByCourseId(courseId);
    }

    @Override
    public List<TrialCourse> listTrialCourses() {
        return mapper.listTrialCourses();
    }

    @Override
    public void deleteTrialCourse(Integer trialId) {
        mapper.deleteTrialCourse(trialId);
    }

    @Override
    public TrialCourse getTrialCourse(Integer trialId) {
        return mapper.getTrialCourse(trialId);
    }
}
