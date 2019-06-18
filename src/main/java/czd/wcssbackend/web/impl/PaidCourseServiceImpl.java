package czd.wcssbackend.web.impl;

import czd.wcssbackend.common.model.courseType.PaidCourse;
import czd.wcssbackend.persistence.mapper.PaidCourseMapper;
import czd.wcssbackend.web.service.PaidCourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName PaidCourseServiceImpl
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/17 20:06
 */
public class PaidCourseServiceImpl implements PaidCourseService {

    @Autowired
    PaidCourseMapper mapper;
    @Override
    public void insertPaidCourse(PaidCourse paidCourse) {
        mapper.insertPaidCourse(paidCourse);

    }

    @Override
    public void updatePaidCourse(PaidCourse paidCourse) {
        mapper.updatePaidCourse(paidCourse);
    }

    @Override
    public List<PaidCourse> listPaidCoursesByCourseId(Integer courseId) {
        return mapper.listPaidCoursesByCourseId(courseId);
    }

    @Override
    public List<PaidCourse> listPaidCoursesByParId(Integer parId) {
        return mapper.listPaidCoursesByParId(parId);
    }

    @Override
    public List<PaidCourse> listPaidCourses() {
        return mapper.listPaidCourses();
    }

    @Override
    public void deletePaidCourse(Integer paidId) {
        mapper.deletePaidCourse(paidId);
    }
    @Override
    public PaidCourse getPaidCourse(Integer paidId) {
        return mapper.getPaidCourse(paidId);
    }
}
