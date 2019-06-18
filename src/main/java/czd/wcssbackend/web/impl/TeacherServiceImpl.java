package czd.wcssbackend.web.impl;

import czd.wcssbackend.common.model.userType.Teacher;
import czd.wcssbackend.persistence.mapper.TeacherMapper;
import czd.wcssbackend.web.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName ParentServiceImpl
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 17:15
 */
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper mapper;
    @Override
    public Teacher getTeacherByTeachId(Integer teachId) {
        return mapper.getTeacherByTeachId(teachId);
    }

    @Override
    public Teacher getTeacherByUserId(Integer userId) {
        return mapper.getTeacherByUserId(userId);
    }

    @Override
    public List<Teacher> listTeachers() {
        return mapper.listTeachers();
    }

    @Override
    public void updateTeacherByTeachId(Teacher teacher) {
        mapper.updateTeacherByTeachId(teacher);
    }

    @Override
    public void insertTeacher(Teacher teacher) {
        mapper.insertTeacher(teacher);
    }
}
