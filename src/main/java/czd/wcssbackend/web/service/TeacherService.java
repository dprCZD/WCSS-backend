package czd.wcssbackend.web.service;

import czd.wcssbackend.common.model.userType.Teacher;

import java.util.List;

/**
 * @ClassName ParentService
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 17:12
 */
public interface TeacherService {

    Teacher getTeacherByTeachId(Integer teachId);

    Teacher getTeacherByUserId( Integer userId);

    List<Teacher> listTeachers();

    void updateTeacherByTeachId(Teacher teacher);

    void insertTeacher(Teacher teacher);
}
