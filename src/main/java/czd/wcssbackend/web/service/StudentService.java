package czd.wcssbackend.web.service;

import czd.wcssbackend.common.model.Parent;
import czd.wcssbackend.common.model.Student;

import java.util.List;

/**
 * @ClassName ParentService
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 17:12
 */
public interface StudentService {

    Student getStudentByStuId( Integer stuId);

    List<Student> getStudentByUserId( Integer userId);

    List<Student> listStudents();

    void updateStudentByStuId( Student student);

    void insertStudent( Student student);
}
